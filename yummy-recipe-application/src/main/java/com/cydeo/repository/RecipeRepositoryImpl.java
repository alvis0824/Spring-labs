package com.cydeo.repository;

import com.cydeo.model.Recipe;
import com.cydeo.service.ShareService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RecipeRepositoryImpl implements RecipeRepository{
    List<Recipe> recipeList = new ArrayList<>();

    @Override
    public boolean saveRecipe(Recipe recipe) {
        recipeList.add(recipe);
        return true;
    }
}
