#!/usr/bin/env ruby

require './cookbook/util/logging'

def cook recipes

    logger = LoggerFactory.getLogger File.basename __FILE__

    recipes.each do |recipe|

        require recipe

        logger.debug ''
        Recipe.title
        Recipe.cook

    end

end

if __FILE__ == $0

    Thread.current[:name] = 'main'

    recipes = [
        './cookbook/recipe_base',
        './cookbook/recipe_loop',
        './cookbook/recipe_command',
        './cookbook/recipe_thread'
    ]

    cook recipes

end
