package com.sx.mvp.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @Author Administrator
 * @Date 2018/5/23 0023 上午 10:54
 * @Description
 */

public class ArticleBean implements Serializable {


    /**
     * curPage : 2
     * datas : [{"apkLink":"","author":"Kross","chapterId":198,"chapterName":"基础概念","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":2924,"link":"https://segmentfault.com/a/1190000014636827","niceDate":"2018-05-14","origin":"","projectLink":"","publishTime":1526306081000,"superChapterId":168,"superChapterName":"基础知识","tags":[],"title":"View.findViewById是深度优先的","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"AI乔治","chapterId":346,"chapterName":"JVM","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":2923,"link":"https://www.jianshu.com/p/63fe09fe1a60","niceDate":"2018-05-14","origin":"","projectLink":"","publishTime":1526306051000,"superChapterId":245,"superChapterName":"Java深入","tags":[],"title":"一篇简单易懂的原理文章，让你把JVM玩弄与手掌之中","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"xujiaji","chapterId":358,"chapterName":"项目基础功能","collect":false,"courseId":13,"desc":"随意变化的气泡布局，Dialog根据点击View的位置定位它的位置，Dialog可定制方向等！","envelopePic":"http://www.wanandroid.com/blogimgs/d1357b2c-fb4b-4319-9f42-9c3cd891939b.png","fresh":false,"id":2922,"link":"http://www.wanandroid.com/blog/show/2130","niceDate":"2018-05-14","origin":"","projectLink":"https://github.com/xujiaji/HappyBubble","publishTime":1526305954000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=358"}],"title":"随意变化的气泡布局 HappyBubble","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"黄名堡","chapterId":94,"chapterName":"事件分发","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":2921,"link":"https://www.jianshu.com/u/05f0e6a41c4e","niceDate":"2018-05-14","origin":"","projectLink":"","publishTime":1526305579000,"superChapterId":134,"superChapterName":"自定义控件","tags":[],"title":"Android手势分发和嵌套滚动机制","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"大神带我来搬砖","chapterId":73,"chapterName":"面试相关","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":2920,"link":"https://www.jianshu.com/p/9fca3a2bf7ec","niceDate":"2018-05-14","origin":"","projectLink":"","publishTime":1526305488000,"superChapterId":61,"superChapterName":"热门专题","tags":[],"title":"从技术面试官的角度谈谈简历和面试那些事儿","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"Java架构","chapterId":73,"chapterName":"面试相关","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":2919,"link":"https://www.jianshu.com/p/eecc252876bc","niceDate":"2018-05-14","origin":"","projectLink":"","publishTime":1526305472000,"superChapterId":61,"superChapterName":"热门专题","tags":[],"title":"Java面试中需要准备哪些多线程并发的技术要点","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"美团点评技术团队","chapterId":30,"chapterName":"Toast","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":2918,"link":"https://mp.weixin.qq.com/s/r8wlKaNsWdffGxuGkpoXbQ","niceDate":"2018-05-14","origin":"","projectLink":"","publishTime":1526305420000,"superChapterId":30,"superChapterName":"用户交互","tags":[],"title":"Toast与Snackbar的那点事","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"骑小猪看流星","chapterId":76,"chapterName":"项目架构","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":2917,"link":"https://www.jianshu.com/p/6021f3f61fa6","niceDate":"2018-05-14","origin":"","projectLink":"","publishTime":1526298650000,"superChapterId":61,"superChapterName":"热门专题","tags":[],"title":"探索Android路由框架-ARouter之基本使用（一）","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"JohnsonZZZ","chapterId":268,"chapterName":"优秀的设计","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":2916,"link":"https://www.jianshu.com/p/09f2689499d0","niceDate":"2018-05-14","origin":"","projectLink":"","publishTime":1526298411000,"superChapterId":135,"superChapterName":"项目必备","tags":[],"title":"优雅地实现Android主流图片加载框架封装，可无侵入切换框架","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"鸿洋公众号","chapterId":73,"chapterName":"面试相关","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":2914,"link":"https://mp.weixin.qq.com/s/KwWbbZt3Rp9Mghj8pFJtYQ","niceDate":"2018-05-14","origin":"","projectLink":"","publishTime":1526277185000,"superChapterId":61,"superChapterName":"热门专题","tags":[],"title":"阿里春招Android面经","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"cuipengfei","chapterId":304,"chapterName":"基础源码","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":2913,"link":"http://cuipengfei.me/blog/2013/06/22/why-does-it-have-to-be-final/","niceDate":"2018-05-14","origin":"","projectLink":"","publishTime":1526269870000,"superChapterId":245,"superChapterName":"Java深入","tags":[],"title":"为什么必须是final的呢？","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"MrTangFB","chapterId":140,"chapterName":"dagger2","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":2912,"link":"https://www.jianshu.com/p/b26024bc3107","niceDate":"2018-05-13","origin":"","projectLink":"","publishTime":1526202351000,"superChapterId":55,"superChapterName":"5.+高新技术","tags":[],"title":"Android Dagger2 从零单排(三) @Scope","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"MrTangFB","chapterId":140,"chapterName":"dagger2","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":2911,"link":"https://www.jianshu.com/p/7ee1a1100fab","niceDate":"2018-05-13","origin":"","projectLink":"","publishTime":1526202336000,"superChapterId":55,"superChapterName":"5.+高新技术","tags":[],"title":"Android Dagger2 从零单排(一) 基础注解","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"MrTangFB","chapterId":140,"chapterName":"dagger2","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":2910,"link":"https://www.jianshu.com/p/b35a658bb1ba","niceDate":"2018-05-13","origin":"","projectLink":"","publishTime":1526202321000,"superChapterId":55,"superChapterName":"5.+高新技术","tags":[],"title":"Android Dagger2 从零单排(二) @Qualifier","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"heimashi","chapterId":333,"chapterName":"性能优化","collect":false,"courseId":13,"desc":"在需要加载数据的方法上添加注解标记，然后利用编译期注解生成页面与加载方法的映射关系，之后就可以在需要提前加载数据的时候调用该方法的路由去提前加载数据了。能明显的提高页面的加载速度，还几乎不影响之前的开发习惯。","envelopePic":"http://www.wanandroid.com/resources/image/pc/default_project_img.jpg","fresh":false,"id":2908,"link":"http://www.wanandroid.com/blog/show/2128","niceDate":"2018-05-13","origin":"","projectLink":"https://github.com/heimashi/and-load-aot","publishTime":1526202132000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=333"}],"title":"预加载优化页面加载速度 and-load-aot","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"鸿洋","chapterId":298,"chapterName":"我的博客","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":2907,"link":"http://www.wanandroid.com/blog/show/2127","niceDate":"2018-05-12","origin":"","projectLink":"","publishTime":1526093225000,"superChapterId":298,"superChapterName":"原创文章","tags":[],"title":"我们要不要上线「个人app」 ？","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"Reiser实验室","chapterId":55,"chapterName":"新的API","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":2906,"link":"https://www.jianshu.com/p/bcbd0769e7ac","niceDate":"2018-05-11","origin":"","projectLink":"","publishTime":1526032105000,"superChapterId":55,"superChapterName":"5.+高新技术","tags":[],"title":"Android Material Design 阴影实现","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"Dawish_大D","chapterId":334,"chapterName":"Architecture Components","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":2905,"link":"https://www.jianshu.com/p/e8955f525f4c","niceDate":"2018-05-11","origin":"","projectLink":"","publishTime":1526031798000,"superChapterId":55,"superChapterName":"5.+高新技术","tags":[],"title":"Android架构组件ViewModel来龙去脉","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"jjlanbupt","chapterId":313,"chapterName":"字节码","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":2904,"link":"https://www.jianshu.com/p/5972220efc9a","niceDate":"2018-05-11","origin":"","projectLink":"","publishTime":1526031659000,"superChapterId":245,"superChapterName":"Java深入","tags":[],"title":"java泛型你需要知道的一切","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"张磊BARON","chapterId":171,"chapterName":"binder","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":2903,"link":"https://www.jianshu.com/p/429a1ff3560c","niceDate":"2018-05-11","origin":"","projectLink":"","publishTime":1526031528000,"superChapterId":173,"superChapterName":"framework","tags":[],"title":"写给 Android 应用工程师的 Binder 原理剖析","type":0,"userId":-1,"visible":1,"zan":0}]
     * offset : 20
     * over : false
     * pageCount : 65
     * size : 20
     * total : 1299
     */

    private int curPage;
    private int offset;
    private boolean over;
    private int pageCount;
    private int size;
    private int total;
    private List<DatasBean> datas;

    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public boolean isOver() {
        return over;
    }

    public void setOver(boolean over) {
        this.over = over;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<DatasBean> getDatas() {
        return datas;
    }

    public void setDatas(List<DatasBean> datas) {
        this.datas = datas;
    }

    public static class DatasBean {
        /**
         * apkLink :
         * author : Kross
         * chapterId : 198
         * chapterName : 基础概念
         * collect : false
         * courseId : 13
         * desc :
         * envelopePic :
         * fresh : false
         * id : 2924
         * link : https://segmentfault.com/a/1190000014636827
         * niceDate : 2018-05-14
         * origin :
         * projectLink :
         * publishTime : 1526306081000
         * superChapterId : 168
         * superChapterName : 基础知识
         * tags : []
         * title : View.findViewById是深度优先的
         * type : 0
         * userId : -1
         * visible : 1
         * zan : 0
         */

        private String apkLink;
        private String author;
        private int chapterId;
        private String chapterName;
        private boolean collect;
        private int courseId;
        private String desc;
        private String envelopePic;
        private boolean fresh;
        private int id;
        private String link;
        private String niceDate;
        private String origin;
        private String projectLink;
        private long publishTime;
        private int superChapterId;
        private String superChapterName;
        private String title;
        private int type;
        private int userId;
        private int visible;
        private int zan;
        private List<?> tags;

        public String getApkLink() {
            return apkLink;
        }

        public void setApkLink(String apkLink) {
            this.apkLink = apkLink;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public int getChapterId() {
            return chapterId;
        }

        public void setChapterId(int chapterId) {
            this.chapterId = chapterId;
        }

        public String getChapterName() {
            return chapterName;
        }

        public void setChapterName(String chapterName) {
            this.chapterName = chapterName;
        }

        public boolean isCollect() {
            return collect;
        }

        public void setCollect(boolean collect) {
            this.collect = collect;
        }

        public int getCourseId() {
            return courseId;
        }

        public void setCourseId(int courseId) {
            this.courseId = courseId;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getEnvelopePic() {
            return envelopePic;
        }

        public void setEnvelopePic(String envelopePic) {
            this.envelopePic = envelopePic;
        }

        public boolean isFresh() {
            return fresh;
        }

        public void setFresh(boolean fresh) {
            this.fresh = fresh;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getNiceDate() {
            return niceDate;
        }

        public void setNiceDate(String niceDate) {
            this.niceDate = niceDate;
        }

        public String getOrigin() {
            return origin;
        }

        public void setOrigin(String origin) {
            this.origin = origin;
        }

        public String getProjectLink() {
            return projectLink;
        }

        public void setProjectLink(String projectLink) {
            this.projectLink = projectLink;
        }

        public long getPublishTime() {
            return publishTime;
        }

        public void setPublishTime(long publishTime) {
            this.publishTime = publishTime;
        }

        public int getSuperChapterId() {
            return superChapterId;
        }

        public void setSuperChapterId(int superChapterId) {
            this.superChapterId = superChapterId;
        }

        public String getSuperChapterName() {
            return superChapterName;
        }

        public void setSuperChapterName(String superChapterName) {
            this.superChapterName = superChapterName;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getVisible() {
            return visible;
        }

        public void setVisible(int visible) {
            this.visible = visible;
        }

        public int getZan() {
            return zan;
        }

        public void setZan(int zan) {
            this.zan = zan;
        }

        public List<?> getTags() {
            return tags;
        }

        public void setTags(List<?> tags) {
            this.tags = tags;
        }
    }
}
