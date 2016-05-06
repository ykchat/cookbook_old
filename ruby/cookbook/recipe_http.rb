#!/usr/bin/env ruby

module Recipe

    require 'net/http'
    require 'json'
    require './cookbook/util/logging'

    class << self

        @@logger = LoggerFactory.getLogger File.basename __FILE__

        def title

            @@logger.debug '# Http'

        end

        def cook

            host = 'weather.livedoor.com'
            api = '/forecast/webservice/json/v1?city=130010'

            ## HTTPリクエスト

            http = Net::HTTP.new(host)
            res = http.get(api)

            ## HTTPレスポンス解析

            data = JSON.parse(res.body)

            location = data['location']
            @@logger.debug "#{location['prefecture']}, #{location['city']}"

            data['forecasts'].each do |forecast|
                @@logger.debug "#{forecast['dateLabel']}[#{forecast['date']}]: #{forecast['telop']}"
            end

        end

    end

end

if __FILE__ == $0

    Recipe.title
    Recipe.cook

end
