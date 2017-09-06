package com.concretepage.controller;

import java.util.List;

import com.concretepage.entity.Asset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;
import com.concretepage.service.IAssetService;

@Controller
@RequestMapping("/")
public class AssetController {
    @Autowired
    private IAssetService assetService;

    @GetMapping("asset/{id}")
    public ResponseEntity<Asset> getAssetById(@PathVariable("id") Integer id) {
        Asset asset = assetService.getAssetById(id);
        return new ResponseEntity<Asset>(asset, HttpStatus.OK);
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

}
