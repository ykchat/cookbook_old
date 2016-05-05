#!/usr/bin/env ruby

module Recipe

    require './cookbook/util/logging'

    class << self

        @@logger = LoggerFactory.getLogger File.basename __FILE__

        def title

            @@logger.debug '# Command'

        end

        def cook

            command = 'ls'

            # コマンド実行

            IO.popen(command) do |pipe|
                # コマンドのpid取得
                pid = pipe.pid
                @@logger.debug "#{command}[##{pid}] started"
                # コマンド実行結果（標準出力）を取得
                pipe.each do |line|
                    @@logger.debug line.chomp
                end
                 @@logger.debug "#{command}[##{pid}] ended"
            end

        end

    end

end

if __FILE__ == $0

    Recipe.title
    Recipe.cook

end
