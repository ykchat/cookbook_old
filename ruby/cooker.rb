#!/usr/bin/env ruby

def cook recipes

    recipes.each do |recipe|

        require recipe

        puts ''
        Recipe.title
        Recipe.cook

    end

end

if __FILE__ == $0

    recipes = [
        './recipes/recipe_base'
    ]

    cook recipes

end
