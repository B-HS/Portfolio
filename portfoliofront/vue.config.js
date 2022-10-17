const { defineConfig } = require('@vue/cli-service')

module.exports = defineConfig({
  transpileDependencies: true,

  devServer: {
    port: 8080,
    proxy : {
      // "/api/" :{target:'http://hyns.co.kr:9099', changeOrigin: true},
      "/api/" :{target:'http://localhost:9099', changeOrigin: true},
    }
},
})
