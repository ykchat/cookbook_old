#!/usr/bin/env ruby

module Recipe

    require './cookbook/util/logging'

    class << self

        @@logger = LoggerFactory.getLogger File.basename __FILE__

        def title

            @@logger.debug '# File'

        end

        def cook

            name =  File.absolute_path('cooker.rb')

            # 基本情報

            @@logger.debug "dir=#{File.dirname(name)}"
            @@logger.debug "file=#{File.basename(name)}"
            @@logger.debug "size=#{File.size(name)}"

            # 行数カウント

            lc = File.readlines(name).size
            @@logger.debug "lc=#{lc}"

            lc = File.foreach(name).count
            @@logger.debug "lc=#{lc}"

            lc = 0
            open(name, 'r') do |file|
                file.each_line do |line|
                    lc += 1
                end
            end
            @@logger.debug "lc=#{lc}"

        end

    end

end

if __FILE__ == $0

    Recipe.title
    Recipe.cook

end
