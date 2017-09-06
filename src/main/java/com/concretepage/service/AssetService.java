package com.concretepage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.concretepage.dao.IAssetDAO;
import com.concretepage.entity.Asset;

@Service
public class AssetService implements IAssetService {
    @Autowired
    private IAssetDAO assetDAO;

    @Override
    public Asset getAssetById(int assetId) {
        Asset obj = assetDAO.getAssetById(assetId);
        return obj;
    }

    @Override
    public List<Asset> getAllAssets() {
        return assetDAO.getAllAssets();
    }

    @Override
    public synchronized boolean addAsset(Asset asset) {
        if (assetDAO.assetExists(asset.getUri())) {
            return false;
        } else {
            assetDAO.addAsset(asset);
            return true;
        }
    }

    @Override
    public void updateAsset(Asset asset) {
        assetDAO.updateAsset(asset);
    }

    @Override
    public void deleteAsset(int assetId) {
        assetDAO.deleteAsset(assetId);
    }
}
