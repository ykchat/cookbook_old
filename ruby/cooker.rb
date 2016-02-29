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
        './cookbook/recipe_base',
        './cookbook/recipe_loop'
    ]

    cook recipes

end
