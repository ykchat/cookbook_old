#!/usr/bin/env ruby

require 'logger'

def cook recipes

    logger = Logger.new(STDOUT)
    logger.level = Logger::DEBUG
    logger.formatter = proc { |severity, datetime, progname, msg|
        "#{datetime.localtime('+09:00').iso8601} [##{$$.to_s.ljust(5)} - #{Thread.current[:name].ljust(8)}] #{File.basename(__FILE__)}: #{severity.ljust(5)} #{msg} \n"
    }

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
        './cookbook/recipe_thread'
    ]

    cook recipes

end
