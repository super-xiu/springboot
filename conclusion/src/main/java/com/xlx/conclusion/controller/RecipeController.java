package com.xlx.conclusion.controller;

import com.xlx.conclusion.entity.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author xlx
 * @Date: 2021/1/13
 * @Description:com.xlx.conclusion.controller
 * @version:1.0
 */

@Controller
public class RecipeController {
   @Autowired
   Recipe recipe;

   @RequestMapping("/findRecipe")
   @ResponseBody
   public Recipe findRecipe(){
       recipe.setRecipeId(1);
       recipe.setRecipeMessage("常用方~~~");
       recipe.setRecipeName("常用方");
       return recipe;
   }
}
