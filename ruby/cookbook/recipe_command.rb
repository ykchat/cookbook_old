#!/usr/bin/env ruby

module Recipe

    require './cookbook/util/logging'

    class << self

        @@logger = LoggerFactory.getLogger File.basename __FILE__

        def title

            @@logger.debug '# Command'

        end

        def cook

            commands = ['ls']

            commands.each do |command|

                IO.popen(command) do |pipe|
                    @@logger.debug "#{command}[##{pipe.pid}] started"
                    pipe.each do |line|
                        @@logger.debug line.chomp
                    end
                    @@logger.debug "#{command}[##{pipe.pid}] ended"
                end

            end

        end

    end

end

if __FILE__ == $0

    Recipe.title
    Recipe.cook

end
