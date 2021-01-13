package com.xlx.conclusion;

import com.xlx.conclusion.entity.Recipe;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SpringBootTest
class ConclusionApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void testMap(){
        Recipe recipe1 = new Recipe(1, "aa", "a1");
        Recipe recipe2 = new Recipe(2, "aa", "a2");
        Recipe recipe3 = new Recipe(3, "bb", "b1");
        List<Recipe> recipes = new ArrayList<>();
        recipes.add(recipe1);
        recipes.add(recipe2);
        recipes.add(recipe3);
        Map<String, Recipe> recipeMap = recipes.stream().collect(Collectors.toMap(Recipe::getRecipeName, a -> a, (k1, k2) -> k1));
        Recipe recipe = recipeMap.get("aa");
        System.out.println(recipe.toString());

        List<Recipe> list = recipes.stream()
                .filter(a -> !"aa".equals(a.getRecipeName()) && !"bb".equals(a.getRecipeName()))
                .filter(a -> a.getRecipeId() == 1).collect(Collectors.toList());
        System.out.println(list.toString());

    }

}
