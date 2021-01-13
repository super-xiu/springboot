package com.xlx.conclusion.entity;

import lombok.Data;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.stereotype.Repository;

/**
 * @author xlx
 * @Date: 2021/1/13
 * @Description:com.xlx.conclusion.entity
 * @version:1.0
 */
@Data
@Repository
public class Recipe {
    private Integer recipeId;
    private String recipeName;
    private String recipeMessage;

    public Recipe(Integer recipeId, String recipeName, String recipeMessage) {
        this.recipeId = recipeId;
        this.recipeName = recipeName;
        this.recipeMessage = recipeMessage;
    }

    public Recipe() {
    }
}
