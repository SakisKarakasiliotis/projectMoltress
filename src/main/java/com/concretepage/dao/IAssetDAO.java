package com.concretepage.dao;

import java.util.List;

import com.concretepage.entity.Asset;

public interface IAssetDAO {
    List<Asset> getAllAssets();

    Asset getAssetById(int assetId);

    List<Asset> getAssetByEstateId(int id, String type);

    void addAsset(Asset asset);

    void updateAsset(Asset asset);

    void deleteAsset(int assetId);

    boolean assetExists(String email);
}