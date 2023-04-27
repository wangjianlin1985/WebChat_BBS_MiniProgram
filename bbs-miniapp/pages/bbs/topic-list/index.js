// pages/topic/index.js
const app = getApp();
var sliderWidth = 57.6; // 需要设置slider的宽度，用于计算中间位置
Page({

  /**
   * 页面的初始数据
   */
  data: {
    tabs: ["全部"],
    activeIndex: 0,
    categoryList: [],
    categoryId: -1,
    inputVal: ''
  },

  tabClick: function (e) {
    this.setData({
      activeIndex: e.currentTarget.id,
      sliderOffset: e.currentTarget.offsetLeft
    });
    
    this.getTopic();
   
  },

  showInput: function() {
    this.setData({
      inputShowed: true
    });
  },

  hideInput: function() {
    this.setData({
      inputVal: "",
      inputShowed: false
    });
    this.getTopic();
  },

  clearInput: function() {
    this.setData({
      inputVal: ""
    });
    this.getTopic();
  },

  inputTyping: function(e) {
    this.setData({
      inputVal: e.detail.value
    });
    
  },

  getCategory(){
    var that = this;
    wx.request({
      url: app.globalData.domain + '/api/category/list',
      data: {

      },
      success: function (res) {
        var categoryList = res.data.categoryList;
        var categories = ['全部'];
        for(var i = 0; i < categoryList.length; i++){
          categories.push(categoryList[i].categoryName)
        }

        that.setData({
          categoryList: res.data.categoryList,
          tabs: categories
        });

        wx.getSystemInfo({
          success: function (res) {
            that.setData({
              sliderLeft: (res.windowWidth / that.data.tabs.length - sliderWidth) / 2,
              sliderOffset: res.windowWidth / that.data.tabs.length * that.data.activeIndex
            });
          }
        });
      }
    })
  },
 
  getTopic: function () {
    var that = this;
    var categoryId = -1;
    if (this.data.activeIndex != 0){
      categoryId = this.data.categoryList[this.data.activeIndex - 1].id
    }
    wx.request({
      url: app.globalData.domain + '/api/topic/list',
      data: {
        categoryId: categoryId,
        title: that.data.inputVal
      },
      success: function (res) {
        that.setData({
          topicList: res.data.topicList
        });
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
    var categoryId = options.categoryId;
    this.getTopic();
  },

  getAdvert: function() {
    var that = this;
    wx.request({
      url: app.globalData.domain + '/api/advert/list',
      data: {
        position: 'shop'
      },
      success: function(res) {
        that.setData({
          bannerList: res.data.advertList
        });
      }
    })
  },

  getNotice: function () {
    var that = this;
    wx.request({
      url: app.globalData.domain + '/api/message/list',
      data: {

      },
      success: function (res) {
        if (res.data.messageList && res.data.messageList.length > 0) {
          that.setData({
            message: res.data.messageList[0]
          })
        }
        that.setData({
          messageList: res.data.messageList
        });
      }
    })
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