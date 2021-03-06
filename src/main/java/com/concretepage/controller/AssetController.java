package com.concretepage.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import com.concretepage.entity.Asset;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;
import com.concretepage.service.IAssetService;

@CrossOrigin(origins = "http://localhost:8090", maxAge = 3600)

@Controller
@RequestMapping("/api")
public class AssetController {

    private final Logger logger = LoggerFactory.getLogger(AssetController.class);
    private static String UPLOADED_FOLDER = "./EarthCorD/earthcord/src/assets/";

    @Autowired
    private IAssetService assetService;

    @GetMapping("asset/{id}")
    public ResponseEntity<Asset> getAssetById(@PathVariable("id") Integer id) {
        Asset asset = assetService.getAssetById(id);
        return new ResponseEntity<Asset>(asset, HttpStatus.OK);
    }
    @GetMapping("asset/{id}/{type}")
    public ResponseEntity<List<Asset>> getAssetByEstateId(@PathVariable("id") Integer id,@PathVariable("type") String type) {
        List<Asset> list  = assetService.getAssetByEstateId(id, type);
        return new ResponseEntity<List<Asset>>(list, HttpStatus.OK);
    }

    @GetMapping("assets")
    public ResponseEntity<List<Asset>> getAllAssets() {
        List<Asset> list = assetService.getAllAssets();
        return new ResponseEntity<List<Asset>>(list, HttpStatus.OK);
    }

    @PostMapping("asset")
    public ResponseEntity<Void> addAsset(@RequestBody Asset asset, UriComponentsBuilder builder) {
        boolean flag = assetService.addAsset(asset);
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/asset/{id}").buildAndExpand(asset.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @PutMapping("asset")
    public ResponseEntity<Asset> updateAsset(@RequestBody Asset asset) {
        assetService.updateAsset(asset);
        return new ResponseEntity<Asset>(asset, HttpStatus.OK);
    }

    @DeleteMapping("asset/{id}")
    public ResponseEntity<Void> deleteAsset(@PathVariable("id") Integer id) {
        assetService.deleteAsset(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("upload/{type}/{id}")
    @ResponseBody
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile uploadfile, @PathVariable("type") String type, @PathVariable("id") Integer id) {
        logger.debug("Single file upload!");

        if (uploadfile.isEmpty()) {
            return new ResponseEntity("please select a file!", HttpStatus.OK);
        }

        try {

            saveUploadedFiles(Arrays.asList(uploadfile), type, id);

        } catch (IOException e) {
            System.out.println(e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Asset a = new Asset();
        a.setItemId(id);
        a.setName(uploadfile.getOriginalFilename());
        a.setType(type);
        a.setUri(uploadfile.getOriginalFilename());
        assetService.addAsset(a);
        return new ResponseEntity("Successfully uploaded - " +
                uploadfile.getOriginalFilename(), HttpStatus.OK);
    }

    private void saveUploadedFiles(List<MultipartFile> files, String type, Integer id) throws IOException {

        for (MultipartFile file : files) {

            if (file.isEmpty()) {
                continue; //next pls
            }

            byte[] bytes = file.getBytes();
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());

            Path path = Paths.get(UPLOADED_FOLDER  + file.getOriginalFilename());
            System.out.println(path);
            Files.write(path, bytes);

        }

    }
}
