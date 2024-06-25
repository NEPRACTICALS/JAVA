package com.rca.mireilleumutoni.template.v1.services;

import com.rca.mireilleumutoni.template.v1.dto.requests.CreateSaveDTO;
import com.rca.mireilleumutoni.template.v1.models.Save;

import java.util.UUID;

public interface SaveService {
    Save createSave(CreateSaveDTO createSaveDTO);
    Save getSaveById(UUID saveId);

    Save updateSave(UUID uuid, CreateSaveDTO createSaveDTO);
}
