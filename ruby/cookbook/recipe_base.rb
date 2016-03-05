#!/usr/bin/env ruby

module Recipe

    require 'logger'
    require 'time'

    class << self

        @@logger = Logger.new(STDOUT)
        @@logger.level = Logger::DEBUG
        @@logger.formatter = proc { |severity, datetime, progname, msg|
            "#{datetime.localtime('+09:00').iso8601} [##{$$.to_s.ljust(5)} - #{Thread.current[:name].ljust(8)}] #{File.basename(__FILE__)}: #{severity.ljust(5)} #{msg} \n"
        }

        def title

            @@logger.debug '# Base'

        end

        def cook

            ## 変数展開

            name = 'Recipe'
            hello = "Hello #{name}!"
            @@logger.debug hello

            ## 現在時刻

            now = Time.now.localtime '+00:00'
            @@logger.debug now

            now = Time.now.localtime '+09:00'
            @@logger.debug now

        end

    end

end

if __FILE__ == $0

    Recipe.title
    Recipe.cook

end
