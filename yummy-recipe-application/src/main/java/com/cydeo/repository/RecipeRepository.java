package com.cydeo.repository;

import com.cydeo.model.Recipe;

public interface RecipeRepository {
    boolean saveRecipe(Recipe recipe);
}
