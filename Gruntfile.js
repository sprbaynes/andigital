module.exports = function(grunt) {

	grunt.initConfig({
        pkg: grunt.file.readJSON('package.json'),

        vars: {
            bowerDir: 'bower_components',
            jsDependencies: 'src/main/webapp/js/dependencies',
            css:'src/main/webapp/styles/css',
            scss: 'src/main/webapp/styles/scss',
            fontsSrc: 'fonts/',
            fontsDest: 'src/main/webapp/js/dependencies/bootstrap/dist/'
        },

        clean: [
            '<%= vars.jsDependencies %>/**/*',
            '<%= vars.css %>/**/*'
        ],

        sass: {
            main: {
                options: {
                    outputStyle: 'compressed',
                    trace: false,
                    sourcemap: true
                },
                files: {
                    '<%= vars.css %>/style.css': '<%= vars.scss %>/*.scss'
                }
            }
        },

        copy: {
            main: {
                files: [{
                    expand: true,
                    cwd: '<%= vars.bowerDir%>/',
                    src: ['**/*.js','!**/*.min.js', '**/*.css' ],
                    dest: '<%= vars.jsDependencies %>/'
                }
                ,{
                     expand: true,
                     cwd: '<%= vars.bowerDir%>/bootstrap',
                     src: ['<%= vars.fontsSrc %>/*' ],
                     dest: '<%= vars.fontsDest %>/'
                 }
                ]
            }
        }

	});

	require('load-grunt-tasks')(grunt);

    grunt.registerTask('default', ['dev']);
    grunt.registerTask('dev', [
        'clean',
        'sass',
        'copy'
    ]);
};
