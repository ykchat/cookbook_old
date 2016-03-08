gulp = require 'gulp'
coffee = require 'gulp-coffee'
del = require 'del'
exec = require('child_process').exec

files = 
    coffee: './src/**/*.coffee'

gulp.task 'build', () ->
    gulp.src files.coffee
        .pipe coffee 
            bare: true
        .pipe gulp.dest 'build'

gulp.task 'run', () ->
    exec 'node cooker.js', 
        cwd: './build/', 
        (error, stdout, stderr) ->
            if stdout
                console.log stdout
            if stderr
                console.log stderr

gulp.task 'clean', () ->
    del ['./build/*']

gulp.task 'watch', () ->
    gulp.watch files.coffee, ['build']

gulp.task 'default', ['build']
