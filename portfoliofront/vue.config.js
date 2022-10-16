const { defineConfig } = require('@vue/cli-service')

module.exports = defineConfig({
  transpileDependencies: true,

  devServer: {
    port: 8080,
    proxy : {
      "/api/" :{target:'http://localhost:10106/', changeOrigin: true},
    }
},
})
