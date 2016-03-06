#!/usr/bin/env ruby

module Recipe

    require 'logger'

    class << self

        @@logger = LoggerFactory.getLogger(File.basename(__FILE__))

        def title

            @@logger.debug '# Thread'

        end

        def cook

            secs = [1.0, 2.0, 3.0]

            threads = Array.new

            count = 0
            secs.each do |sec|
                count += 1
                threads << Thread.new(count, sec) do |_count, _sec|
                    Thread.current[:name] = "thread-#{_count}"
                    __sleep(_sec)
                end
            end

            threads.each do |thread|
                thread.join if thread.alive?
            end

            @@logger.debug 'all ended'

        end

        def __sleep(sec)

            @@logger.debug "sleep(#{sec}) started"
            sleep sec
            @@logger.debug "sleep(#{sec}) ended"

        end

    end

end

if __FILE__ == $0

    Recipe.title
    Recipe.cook

end
