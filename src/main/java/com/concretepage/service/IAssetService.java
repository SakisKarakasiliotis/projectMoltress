package com.concretepage.service;
import java.util.List;

import com.concretepage.entity.Asset;

public interface IAssetService {
    List<Asset> getAllAssets();

    Asset getAssetById(int assetId);

    List<Asset> getAssetByEstateId(int id, String type);

    boolean addAsset(Asset asset);

    void updateAsset(Asset asset);

    void deleteAsset(int assetId);
}
