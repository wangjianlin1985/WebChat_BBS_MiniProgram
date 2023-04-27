// pages/topic/index.js
const app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {

  },

  getTopic: function () {
    var that = this;
    wx.request({
      url: app.globalData.domain + '/api/topic/mylist',
      header: {
        token: app.globalData.token
      },
      data: {
        
      },
      success: function (res) {
        that.setData({
          topicList: res.data.topicList
        });
      }
    })
  },

  del: function (e) {
    var id = e.currentTarget.dataset.id;
    var that = this;
    wx.request({
      url: app.globalData.domain + '/api/topic/del',
      header: {
        token: app.globalData.token
      },
      data: {
        id: id
      },
      success: function (res) {
        that.getTopic();
      }
    })
  },

  addTopic: function(){
    if (!app.globalData.userInfo.realName) {
      wx.navigateTo({
        url: '/pages/user-info/index',
      })
      return;
    }
    wx.navigateTo({
      url: '/pages/topic-add/index',
    })
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
    this.getTopic();
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})