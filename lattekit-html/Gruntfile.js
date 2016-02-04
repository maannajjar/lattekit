module.exports = function(grunt) {
  require('jit-grunt')(grunt)

  grunt.initConfig({
    pkg: grunt.file.readJSON('package.json'),

    sass: {
        dist: {
            files: {
                'build/css/main.css': 'src/sass/main.scss'
            }
        }
    },
    copy: {
      main: {
        files: [
          {
            cwd: 'static',
            expand: true,
            src: ['**/*'],
            dest: 'build',
          }
        ]
      }
    },
    watch: {
      vendor: {
        files: ['static/**/*'],
        tasks: ['copy']
      },

      css: {
        files: 'src/sass/**/*.scss',
        tasks: ['sass']
      }
    },

    browserify: {
      dev: {
        options: {
          transform: [  ["babelify", { 
            optional: ["es7.objectRestSpread"]
          }] ],
          watch: true,
          browserifyOptions: {
            debug: true
          }

        },
        files: {
          'build/js/app.min.js' : 'src/jsx/App.jsx'
        }
      }
    }
  });

  grunt.registerTask('default', [
    'copy',
    'sass',
    'browserify',
    'watch'
  ]);
};
