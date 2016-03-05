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

    Thread.current[:name] = 'main'

    recipes = [
        './cookbook/recipe_base',
        './cookbook/recipe_loop',
        './cookbook/recipe_thread'
    ]

    cook recipes

end
