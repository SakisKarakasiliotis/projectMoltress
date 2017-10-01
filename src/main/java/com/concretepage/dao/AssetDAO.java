package com.concretepage.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.concretepage.entity.Asset;

@Transactional
@Repository
public class AssetDAO implements IAssetDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Asset getAssetById(int assetId) {
        return entityManager.find(Asset.class, assetId);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Asset> getAllAssets() {
        String hql = "FROM Asset as ast ORDER BY ast.id";
        return (List<Asset>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public List<Asset> getAssetByEstateId(int id, String type){
        String hql = "FROM Asset as ast WHERE ast.itemId = ? AND ast.type = ?";
        return (List<Asset>) entityManager.createQuery(hql).setParameter(1, id).setParameter(2, type).getResultList();
    }


    @Override
    public void addAsset(Asset asset) {
        entityManager.persist(asset);
    }

    @Override
    public void updateAsset(Asset asset) {
        Asset ast = getAssetById(asset.getId());
        if (asset.getUri() != null) {
            ast.setUri(asset.getUri());
        }
        if (asset.getType() != null) {

            ast.setType(asset.getType());
        }
        if (asset.getName() != null) {
            ast.setName(asset.getName());
        }
        if (asset.getItemId() != null) {
            ast.setItemId(asset.getItemId());
        }
        if (asset.getDescription() != null) {
            ast.setDescription(asset.getDescription());
        }

        entityManager.flush();
    }

    @Override
    public void deleteAsset(int assetId) {
        entityManager.remove(getAssetById(assetId));
    }

    @Override
    public boolean assetExists(String uri) {
        String hql = "FROM Asset as ast WHERE ast.uri = ?";
        int count = entityManager.createQuery(hql).setParameter(1, uri).getResultList().size();
        return count > 0 ? true : false;
    }
}
