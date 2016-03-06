#!/usr/bin/env ruby

module LoggerFactory

    require 'logger'

    class << self

        @@__loggers = Hash.new

        def getLogger(name)

            if @@__loggers.key?(name) then
                return @@__loggers[name]
            end

            logger = Logger.new(STDOUT)
            logger.level = Logger::DEBUG
            logger.formatter = proc { |severity, datetime, progname, msg|
                "#{datetime.localtime('+09:00').iso8601} [##{$$.to_s.ljust(5)} - #{Thread.current[:name].ljust(8)}] #{name}: #{severity.ljust(5)} #{msg} \n"
            }

            @@__loggers[name] = logger

            return logger

        end

    end

end
