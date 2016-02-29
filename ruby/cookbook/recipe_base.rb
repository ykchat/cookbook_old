#!/usr/bin/env ruby

module Recipe

    require 'time'

    class << self

        def title

            puts '# Base'

        end

        def cook

            ## 変数展開

            name = 'Recipe'
            hello = "Hello #{name}!"
            puts hello

            ## 現在時刻

            now = Time.now.localtime '+00:00'
            puts now

            now = Time.now.localtime '+09:00'
            puts now

        end

    end

end

if __FILE__ == $0

    Recipe.title
    Recipe.cook

end
