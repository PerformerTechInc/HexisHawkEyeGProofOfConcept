package com.mlb.qa.tests.web.homebase;

import com.mlb.qa.gui.pages.homebaseproject.HB_HomePage;
import com.qaprosoft.carina.core.foundation.UITest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HomebaseTestSuite extends UITest {

    //************ TEXT FIELD VALUES ************//
    //************ TEXT FIELD VALUES ************//
    //************ TEXT FIELD VALUES ************//


    //************ ITEM OBJECTS ************//
    private final String selectNewItemArticle = "Article";
    private final String selectNewItemArticleView = "Article View";
    private final String selectNewItemAudioSchedule = "Audio Schedule";
    private final String selectNewItemBallpark = "Ballpark";
    private final String selectNewItemBallparkMenu = "Ballpark Menu";
    private final String selectNewItemBallparkMusic = "Ballpark Music";
    private final String selectNewItemBallparkSubmenu = "Ballpark Submenu";
    private final String selectNewItemBlogContent = "Blog Content";
    private final String selectNewItemBlogContentAlias = "Blog Content Alias";
    private final String selectNewItemChron = "Chron";
    private final String selectNewItemClosedCaption = "Closed Caption";
    private final String selectNewItemClubPromo = "Club Promo";
    private final String selectNewItemContributor = "Contributor";
    private final String selectNewItemDailyEmail = "Daily Email";
    private final String selectNewItemDeviceAnnouncement = "Device Announcement";
    private final String selectNewItemDeviceBanner = "Device Banner";
    private final String selectNewItemDevicePage = "Device Page";
    private final String selectNewItemDigitalAsset = "Digital Asset";
    private final String selectNewItemDrawer = "Drawer";
    private final String selectNewItemEvent = "Event";
    private final String selectNewItemFeature = "Feature";
    private final String selectNewItemFeatures = "Features";
    private final String selectNewItemFieldOption = "Field Option";
    private final String selectNewItemGamePreview = "Game Preview";
    private final String selectNewItemGameWrap = "Game Wrap";
    private final String selectNewItemHighlight = "Hightlight";
    private final String selectNewItemHomepageTab = "Homepage Tab";
    private final String selectNewItemHPConfig = "HP Config";
    private final String selectNewItemIncludeHTML = "Include - HTML";
    private final String selectNewItemInstagramPhoto = "Instagram Photo";
    private final String selectNewItemSocialMediaStream = "Social Media Stream";
    private final String selectNewItemKiosk = "Kiosk";
    private final String selectNewItemLineup = "Lineup";
    private final String selectNewItemLineupPlayer = "Lineup Player";
    private final String selectNewItemLink = "Link";
    private final String selectNewItemList = "List";
    private final String selectNewItemMediawall = "Mediawall";
    private final String selectNewItemMediawallOverlay = "Mediawall Overlay";
    private final String selectNewItemMediawallPanel = "Mediawall Panel";
    private final String selectNewItemMLBTVAdModule = "MLBTV Ad Module";
    private final String selectNewItemMoundBall = "Mound Ball";
    private final String selectNewItemMusicLink = "Music Link";
    private final String selectNewItemNote = "Note";
    private final String selectNewItemNotebook = "Notebook";
    private final String selectNewItemPage = "Page";
    private final String selectNewItemPhotoGallery = "Photo Gallery";
    private final String selectNewItemPhotoGalleryAlias = "Photo Gallery Alias";
    private final String selectNewItemPhotoGalleryList = "Photo Gallery List";
    private final String selectNewItemPlayerProspect = "Player Prospect";
    private final String selectNewItemPodcastDetail = "Podcast Detail Page";
    private final String selectNewItemPodcastEpisode = "Podcast Episode";
    private final String selectNewItemPressRelease = "Press Release";
    private final String selectNewItemPressboxAsset = "Pressbox Asset";
    private final String selectNewItemPressboxAssetList = "Pressbox Asset List";
    private final String selectNewItemPreviewAlias = "Preview Alias";
    private final String selectNewItemProgramShow = "Program Show";
    private final String selectNewItemPromoApplication = "Promo Application";
    private final String selectNewItemQuoteSheet = "Quote Sheet";
    private final String selectNewItemRaffle = "Raffle";
    private final String selectNewItemSchedule = "Schedule";
    private final String selectNewItemScrapbook = "Scrapbook";
    private final String selectNewItemScrapbookPage = "Scrapbook Page";
    private final String selectNewItemSection = "Section";
    private final String selectNewItemSeriesConfiguration = "Series Configuration";
    private final String selectNewItemShortContent = "Short Content";
    private final String selectNewItemTicketPage = "Ticket Page";
    private final String selectNewItemTrendingModule = "Trending Module";
    private final String selectNewItemTweet = "Tweet";
    private final String selectNewItemVideoTopicPage = "Video Topic Page";
    private final String selectNewItemTwitterHandle = "Twitter Handle";
    private final String selectNewItemVideoClipList = "Video Clip List";
    private final String selectNewItemHTMLPage = "HTML Page";
    //************ ITEM OBJECTS ************//

    //************ LOGIN OBJECTS ************//
    private static final String mainURL = "https://qahomebase.mlbcontrol.net/";
    public static String mainURL2 = "https://qahomebase.mlbcontrol.net/";
    private static final String loginUser = "editorhb";
    private static final String loginPassword = "B@tter1Up!";
    //************ LOGIN OBJECTS ************//

    //************ BETA/PROD OBJECTS ************//
    private static final String valueBeta = "beta";
    public static String valueProd = "prod";
    //************ BETA/PROD OBJECTS ************//

    //************ MINOR LEAGUE OBJECTS ************//
    private static final String minorLeagueSiteSelection = "milb";
    private static final String valueMinorTagToolPlayer = "Jones";
    //************ MINOR LEAGUE OBJECTS ************//

    //************ MAJOR LEAGUE OBJECTS ************//
    private static final String majorLeagueSiteSelection = "mlb";
    private static final String valueMajorTagToolPlayer = "Smith";
    //************ MAJOR LEAGUE OBJECTS ************//

    //************ SEARCH OBJECTS ************//
    private static final String valueBasicSearch = "sd:2014-01-01|ed:2014-04-15|kw:baseball|";
    //************ SEARCH OBJECTS ************//

    //************ ARTICLE OBJECTS ************//
    private static final String valueArticleInternalName = "Internal Name";
    private static final String valueArticleHeadline = "Headline";
    private static final String valueArticleSubhead = "Subhead";
    private static final String valueArticleAltHeadline = "Alt Headline";
    private static final String valueArticleByline = "Byline";
    private static final String valueArticleSeoHeadline = "SEO Headline";
    private static final String valueArticlePoll = "Poll";
    private static final String valueArticleBlurb = "Blurb";
    private static final String valueArticleNotes = "Notes";
    private static final String valueArticleTagline = "Tagline";
    //************ ARTICLE OBJECTS ************//

    //************ ARTICLE-VIEW OBJECTS ************//
    private static final String valueArticleViewInternalName = "Internal Name";
    private static final String valueArticleViewName = "Name";
    private static final String valueArticleViewViewKey = "View Key";
    //************ ARTICLE-VIEW OBJECTS ************//

    //************ AUDIO SCHEDULE OBJECTS ************//
    private static final String valueAudioScheduleInternalName = "Internal Name";
    //************ AUDIO SCHEDULE OBJECTS ************//

    //************ BALLPARK OBJECTS ************//
    private static final String valueBallparkInternalName = "Internal Name";
    private static final String valueBallparkID = "ID";
    private static final String valueBallparkName = "Name";
    private static final String valueBallparkAddress1 = "123 Address1";
    private static final String valueBallparkAddress2 = "Apt Address2";
    private static final String valueBallparkLocation = "Location";
    private static final String valueBallparkMapType = "Map Type";
    private static final String valueBallparkMapVersion = "Map Version 1.0";
    private static final String valueBallparkFacebookID = "Facebook ID";
    private static final String valueBallparkFoursquareID = "Foursquare ID";
    private static final String valueBallparkWebsiteURL = "http://www.WebsiteURL.com";
    private static final String valueBallparkThumbnailURL = "http://www.ThumbnailURL.com";
    private static final String valueBallparkThumbnailCaption = "Thumbnail Caption";
    private static final String valueBallparkTwitterHashTags = "#Twitter #Hash #Tags";
    private static final String valueBallparkAboutURL = "http://www.AboutURL.com";
    private static final String valueBallparkScheduleURL = "http://www.ScheduleURL.com";
    private static final String valueBallparkSmallThumbnailURL = "http://www.SmallThumbnailURL.com";
    private static final String valueBallparkStartYear = "Start Year";
    private static final String valueBallparkEndYear = "End Year";
    private static final String valueBallparkUpgradeURL = "Upgrade URL";
    private static final String valueBallparkAbout = "About";
    private static final String valueBallparkEventsText = "Events Text";
    private static final String valueBallparkSponsorImageText = "Sponsor Image Text";
    private static final String valueBallparkSponsorImageURL = "http://www.SponsorImageURL.com";
    private static final String valueBallparkSponsorImage2Text = "Sponsor Image 2 Text";
    private static final String valueBallparkSponsorImage2URL = "http://www.SponsorImage2URL.com";
    private static final String valueBallparkTicketsText = "Tickets Text";
    private static final String valueBallparkTicketsURL = "http://www.TicketsURL.com";
    private static final String valueBallparkTicketsErrorText = "Tickets Error Text";
    //************ BALLPARK OBJECTS ************//

    //************ BALLPARK MENU OBJECTS ************//
    private static final String valueBallparkMenuInternalName = "Internal Name";
    private static final String valueBallparkMenuDisplayName = "Display Name";
    private static final String valueBallparkMenuDisplayImageURL = "http://www.DisplayImageURL.com";
    private static final String valueBallparkMenuLinkURL = "http:/www.LinkURL.com";
    private static final String valueBallparkMenuLinkName = "Menu Link Name";
    private static final String valueBallparkMenuBundleKey = "Bundle Key";
    private static final String valueBallparkMenuBundleName = "Bundle Name";
    private static final String valueBallparkMenuBundleURL = "http://www.BundleURL.com";
    private static final String valueBallparkMenuSharingURL = "http://www.SharingURL.com";
    private static final String valueBallparkMenuSharingText = "Sharing Text";
    private static final String valueBallparkMenuErrorText = "Error Text";
    private static final String valueBallparkMenuSourceURL = "http://www.SourceURL.com";
    //************ BALLPARK MENU OBJECTS ************//

    //************ BALLPARK MUSIC OBJECTS ************//
    private static final String valueBallparkMusicInternalName = "Internal Name";
    private static final String valueBallparkMusicTitle = "Title";
    private static final String valueBallparkMusicArtist = "Artist";
    private static final String valueBallparkMusicDescription = "Description";
    private static final String valueBallparkMusicThumbnail = "Thumbnail";
    private static final String valueBallparkMusicRank = "Rank";
    //************ BALLPARK MUSIC OBJECTS ************//

    //************ BALLPARK SUBMENU OBJECTS ************//
    public static String valueBallparkSubmenuInternalName = "Internal Name";
    public static String valueBallparkSubmenuDisplayName = "Display Name";
    public static String valueBallparkSubmenuDisplayImageURL = "http://www.DisplayImageURL.com";
    public static String valueBallparkSubmenuLinkURL = "http:/www.LinkURL.com";
    public static String valueBallparkSubmenuLinkName = "Menu Link Name";
    public static String valueBallparkSubmenuBundleKey = "Bundle Key";
    public static String valueBallparkSubmenuBundleName = "Bundle Name";
    public static String valueBallparkSubmenuBundleURL = "http://www.BundleURL.com";
    public static String valueBallparkSubmenuSharingURL = "http://www.SharingURL.com";
    public static String valueBallparkSubmenuSharingText = "Sharing Text";
    public static String valueBallparkSubmenuErrorText = "Error Text";
    public static String valueBallparkSubmenuSourceURL = "http://www.SourceURL.com";
    //************ BALLPARK SUBMENU OBJECTS ************//

    //************ BLOG CONTENT OBJECTS ************//
    private static final String valueBlogContentInternalName = "Internal Name";
    private static final String valueBlogContentURL = "http://www.URL.com";
    private static final String valueBlogContentURLText = "URL Text";
    private static final String valueBlogContentHeadline = "Headline";
    private static final String valueBlogContentAltHeadline = "Alt Headline";
    private static final String valueBlogContentSEOHeadline = "SEO Headline";
    private static final String valueBlogContentBlurb = "Blurb";
    private static final String valueBlogContentByline = "Byline";
    private static final String valueBlogContentCaption = "Caption";
    private static final String valueBlogContentMediaCredit = "Media Credit";
    private static final String valueBlogContentBody = "Body";
    private static final String valueBlogContentSummary = "Summary";
    //************ BLOG CONTENT OBJECTS ************//

    //************ BLOG CONTENT OBJECTS ALIAS ************//
    private static final String valueBlogContentAliasInternalName = "Internal Name";
    private static final String valueBlogContentAliasHeadline = "Headline";
    private static final String valueBlogContentAliasBlurb = "Blurb";
    private static final String valueBlogContentAliasSummary = "Summary";
    //************ BLOG CONTENT OBJECTS ALIAS ************//

    //************ CHRON OBJECTS ************//
    private static final String valueChronInternalName = "Internal Name";
    private static final String valueChronDateNotation = "Date Notation";
    private static final String valueChronYear = "Year";
    private static final String valueChronDisplayYear = "Display Year";
    private static final String valueChronTitle = "Title";
    private static final String valueChronCMSDescription = "CMS Description";
    //************ CHRON OBJECTS ************//

    //************ CLOSED CAPTION OBJECTS ************//
    private static final String valueClosedCaptionInternalName = "Internal Name";
    //************ CLOSED CAPTION OBJECTS ************//

    //************ CLUB PROMO OBJECTS ************//
    private static final String valueClubPromoInternalName = "Internal Name";
    private static final String valueClubPromoURLExtension = "URL Extension";
    private static final String valueClubPromoEventTitle = "Event Title";
    private static final String valueClubPromoEventSubtitle = "Event Subtitle";
    private static final String valueClubPromoPromoText = "Promo Text";
    private static final String valueClubPromoMobileTicketsText = "Mobile Tickets Text";
    private static final String valueClubPromoMobileTicketsURL = "http://www.MobileTicketsURL.com";
    private static final String valueClubPromoTicketsURL = "http://www.TicketsURL.com";
    private static final String valueClubPromoTextCampaignPromo = "Text Campaign Promo";
    private static final String valueClubPromoSocialKeyword = "Social Keyword";
    private static final String valueClubPromoHighlightsTitle = "Highlights Title";
    private static final String valueClubPromoLocationAddress = "Location Address";
    private static final String valueClubPromoEventMapTitle = "Event Map Title";
    private static final String valueClubPromoScheduleTitle = "Schedule Title";
    private static final String valueClubPromoFAQTitle = "FAQ Title";
    //************ CLUB PROMO OBJECTS ************//

    //************ CONTRIBUTOR OBJECTS ************//
    private static final String valueContributorInternalName = "Internal Name";
    private static final String valueContributorFirstName = "First Name";
    private static final String valueContributorLastName = "Last Name";
    private static final String valueContributorTitle = "Title";
    private static final String valueContributorEmail = "Email@mlb.com";
    private static final String valueContributorTwitterHandle = "@TwitterHandle";
    private static final String valueContributorBlog = "Blog";
    private static final String valueContributorBlogTitle = "Blog Title";
    private static final String valueContributorRSSFeed = "RSS Feed";
    private static final String valueContributorFacebookID = "Facebook ID";
    private static final String valueContributorActiveTab = "Active Tab";
    private static final String valueContributorHideArticles = "Hide Articles";
    private static final String valueContributorVideoKeywordType = "Video Keyword Type";
    private static final String valueContributorVideoKeywordValue = "Video Keyword Value";
    private static final String valueContributorVideoLandingPage = "Video Landing Page";
    private static final String valueContributorBlurb = "Blurb";
    //************ CONTRIBUTOR OBJECTS ************//

    //************ DAILY EMAIL  OBJECTS ************//
    private static final String valueDailyEmailInternalName = "Internal Name";
    private static final String valueDailyEmailSubject = "Subject";
    private static final String valueDailyEmailSubjectB = "Subject B";
    private static final String valueDailyEmailTriviaQuestion = "Trivia Question";
    private static final String valueDailyEmailTriviaAnswer = "Trivia Answer";
    //************ DAILY EMAIL  OBJECTS ************//

    //************ DEVICE ANNOUNCEMENT OBJECTS ************//
    private static final String valueDeviceAnnouncementInternalName = "Internal Name";
    private static final String valueDeviceAnnouncementAppVersion = "App Version";
    private static final String valueDeviceAnnouncementOSVersion = "OS Version";
    private static final String valueDeviceAnnouncementEntitlement = "Entitlement";
    private static final String valueDeviceAnnouncementScreen = "Screen";
    private static final String valueDeviceAnnouncementType = "Type";
    private static final String valueDeviceAnnouncementDisplayType = "Display Type";
    private static final String valueDeviceAnnouncementTitle = "Title";
    private static final String valueDeviceAnnouncementMessage = "Message";
    private static final String valueDeviceAnnouncementOpenLabel = "Open Label";
    private static final String valueDeviceAnnouncementOpenLink = "Open Link";
    private static final String valueDeviceAnnouncementCloseLabel = "Close Label";
    private static final String valueDeviceAnnouncementCloseLink = "Close Link";
    //************ DEVICE ANNOUNCEMENT OBJECTS ************//

    //************ DEVICE BANNER OBJECTS ************//
    private static final String valueDeviceBannerInternalName = "Internal Name";
    private static final String valueDeviceBannerAppVersion = "App Version";
    private static final String valueDeviceBannerOSVersion = "OS Version";
    private static final String valueDeviceBannerEntitlement = "Entitlement";
    private static final String valueDeviceBannerAccessFeature = "Access Feature";
    private static final String valueDeviceBannerScreen = "Screen";
    private static final String valueDeviceBannerViewID = "View ID";
    private static final String valueDeviceBannerType = "Type";
    private static final String valueDeviceBannerWebViewType = "Web View Type";
    public static String valueDeviceBannerTitle = "Title";
    private static final String valueDeviceBannerLink = "Link";
    private static final String valueDeviceBannerBackgroundColor = "Background Color";
    private static final String valueDeviceBannerTrackingString = "Tracking String";
    private static final String valueDeviceBannerAdMarvelID = "Ad Marvel ID";
    private static final String valueDeviceBannerAdMarvelWidth = "Ad Marvel Width";
    private static final String valueDeviceBannerAdMarvelHeight = "Ad Marvel Height";
    private static final String valueDeviceBannerAdMarvelSectionID = "Ad Marvel Section ID";
    private static final String valueDeviceBannerAdMarvelMLBTarget = "Ad Marvel MLB Target";
    private static final String valueDeviceBannerAdMarvelExpiryTime = "Ad Marvel Expiry Time";
    private static final String valueDeviceBannerMLBTVContentID = "MLB.tv Content ID";
    private static final String valueDeviceBannerMLBTVCalendarEventID = "MLB.tv Calendar Event ID";
    private static final String valueDeviceBannerSponsor = "Sponsor";
    //************ DEVICE BANNER OBJECTS ************//

    //************ DEVICE PAGE OBJECTS ************//
    private static final String valueDevicePageInternalName = "Internal Name";
    private static final String valueDevicePageHeadline = "Headline";
    private static final String valueDevicePageBlurb = "Blurb";
    private static final String valueDevicePageYearlyPurchaseFlow = "Yearly Purchase Flow";
    private static final String valueDevicePageMonthlyPurchaseFlow = "Monthly Purchase Flow";
    private static final String valueDevicePageUpgradeLink = "http://www.UpgradeLink.com";
    private static final String valueDevicePageActivationLink = "http://www.ActivationLink.com";
    //************ DEVICE PAGE OBJECTS ************//

    //************ DIGITAL ASSET OBJECTS ************//
    private static final String valueDigitalAssetInternalName = "Internal Name";
    private static final String valueDigitalAssetHeadline = "Headline";
    //************ DIGITAL ASSET OBJECTS ************//

    //************ DRAWER OBJECTS ************//
    private static final String valueDrawerInternalName = "Internal Name";
    private static final String valueDrawerKicker = "Kicker";
    private static final String valueDrawerCustomContent = "Custom Content";
    private static final String valueDrawerBlurb = "Blurb";
    private static final String valueDrawerURL = "http://www.URL.com";
    private static final String valueDrawerURLText = "URL Text";
    private static final String valueDrawerNumberOfItems = "2";
    //************ DRAWER OBJECTS ************//

    //************ EVENT OBJECTS ************//
    private static final String valueEventInternalName = "Internal Name";
    private static final String valueEventProgramID = "Program ID";
    private static final String valueEventProgram = "Program";
    private static final String valueEventLocation = "Location";
    private static final String valueEventEventTitle = "Event Title";
    private static final String valueEventDescription = "Event Description";
    private static final String valueEventURL = "http://www.EventURL.com";
    //************ EVENT OBJECTS ************//

    //************ FEATURE OBJECTS ************//
    private static final String valueFeatureInternalName = "Internal Name";
    private static final String valueFeatureHeadline = "Headline";
    private static final String valueFeatureURL = "http://www.URL.com";
    private static final String valueFeatureURLText = "URL Text";
    private static final String valueFeatureMobileURL = "http://www.MobileURL.com";
    private static final String valueFeatureBlurb = "Blurb";
    //************ FEATURE OBJECTS ************//

    //************ FEATURES OBJECTS ************//
    private static final String valueFeaturesInternalName = "Internal Name";
    private static final String valueFeaturesNumberOfItems = "2";
    //************ FEATURES OBJECTS ************//

    //************ FIELD OPTION OBJECTS ************//
    private static final String valueFieldOptionInternalName = "Internal Name";
    private static final String valueFieldOptionDisplayName = "Display Name";
    private static final String valueFieldOptionValue = "Value";
    //************ FIELD OPTION OBJECTS ************//

    //************ GAME PREVIEW OBJECTS ************//
    private static final String valueGamePreviewInternalName = "Internal Name";
    private static final String valueGamePreviewHeadline = "Headline";
    private static final String valueGamePreviewHomeHeadline = "Home Headline";
    private static final String valueGamePreviewAwayHeadline = "Away Headline";
    private static final String valueGamePreviewSubhead = "Subhead";
    private static final String valueGamePreviewAltHeadline = "Alt Headline";
    private static final String valueGamePreviewByline = "Byline";
    private static final String valueGamePreviewBlurb = "Blurb";
    //************ GAME PREVIEW OBJECTS ************//

    //************ GAME WRAP OBJECTS ************//
    private static final String valueGameWrapInternalName = "Internal Name";
    private static final String valueGameWrapHeadline = "Headline";
    private static final String valueGameWrapBlurb = "Blurb";

    //************ GAME WRAP OBJECTS ************//

    //************ HIGHLIGHT OBJECTS ************//
    private static final String valueHighlightInternalName = "Internal Name";
    private static final String valueHighlightYear = "1982";
    //************ HIGHLIGHT OBJECTS ************//

    //************ HOMEPAGE TAB OBJECTS ************//
    private static final String valueHomepageTabInternalName = "Internal Name";
    private static final String valueHomepageTabDefaultAltText = "Default Alt Text";
    private static final String valueHomepageTabDefaultClickthroughURL = "http://www.DefaultClickthroughURL.com";
    //************ HOMEPAGE TAB OBJECTS ************//

    //************ HP CONFIG OBJECTS ************//
    private static final String valueHPConfigInternalName = "Internal Name";
    private static final String valueHPConfigBreakingNews = "Breaking News";
    private static final String valueHPConfigBreakingNewsURL = "http://www.BreakingNewsURL.com";
    private static final String valueHPConfigABTests = "AB Tests";
    private static final String valueHPConfigHeaderURL = "http://www.HeaderURL.com";
    private static final String valueHPConfigHeaderAlt = "Header Alt";
    //************ HP CONFIG OBJECTS ************//

    //************ HTML PAGE OBJECTS ************//
    private static final String valueHTMLPageInternalName = "Internal Name";
    private static final String valueHTMLPageHeadline = "Headline";
    private static final String valueHTMLPageBlurb = "Blurb";
    //************ HTML PAGE OBJECTS ************//

    //************ HTML INCLUDE OBJECTS ************//
    private static final String valueHTMLIncludeInternalName = "Internal Name";
    //************ HTML INCLUDE OBJECTS ************//

    //************ INSTAGRAM PHOTO OBJECTS ************//
    private static final String valueInstagramPhotoInternalName = "Internal Name";
    private static final String valueInstagramPhotoApprover = "Photo Approver";
    private static final String valueInstagramPhotoApprovedTime = "Approved Time";
    private static final String valueInstagramPhotoInstagramID = "Instagram ID";
    private static final String valueInstagramPhotoImageURL = "http://www.ImageURL.com";
    private static final String valueInstagramPhotoLargeImageURL = "http://www.LargeImageURL.com";
    private static final String valueInstagramPhotoCaption = "Caption";
    private static final String valueInstagramPhotoCreatorID = "Creator ID";
    private static final String valueInstagramPhotoCreatorName = "Creator Name";
    private static final String valueInstagramPhotoCreatorProfilePicture = "http://www.CreatorProfilePicture.com";
    private static final String valueInstagramPhotoCreatedTime = "Created Time";
    private static final String valueInstagramPhotoLatitude = "Latitude";
    private static final String valueInstagramPhotoLongitude = "Longitude";
    //************ INSTAGRAM PHOTO OBJECTS ************//

    //************ KIOSK OBJECTS ************//
    private static final String valueKioskInternalName = "Internal Name";
    private static final String valueKioskCalendarEventID = "Calendar Event ID";
    private static final String valueKioskContentID = "ContentID";
    //************ KIOSK OBJECTS ************//

    //************ LINEUP OBJECTS ************//
    private static final String valueLineupInternalName = "Internal Name";
    private static final String valueLineupUmpireHP = "1";
    private static final String valueLineupUmpire1st = "2";
    private static final String valueLineupUmpire2nd = "3";
    private static final String valueLineupUmpire3rd = "4";
    private static final String valueLineupUmpireLF = "5";
    private static final String valueLineupUmpireRF = "6";
    private static final String valueLineupUmpireOS = "7";
    private static final String valueLineupNotes = "Notes";
    //************ LINEUP OBJECTS ************//

    //************ LINEUP PLAYER OBJECTS ************//
    private static final String valueLineupPlayerInternalName = "Internal Name";
    private static final String valueLineupPlayerPosition = "Player Position";
    //************ LINEUP PLAYER OBJECTS ************//

    //************ LINK OBJECTS ************//
    private static final String valueLinkInternalName = "Internal Name";
    private static final String valueLinkLinkText = "Link Test";
    private static final String valueLinkLinkURL = "http://www.milb.com";
    private static final String valueLinkWidth = "320";
    private static final String valueLinkHeight = "240";
    //************ LINK OBJECTS ************//

    //************ LINK OBJECTS ************//
    private static final String valueListInternalName = "Internal Name";
    private static final String valueListKey = "Key";
    private static final String valueListNumberOfItems = "3";
    private static final String valueListBlurb = "Blurb";
    //************ LINK OBJECTS ************//

    //************ MEDIAWALL OBJECTS ************//
    private static final String valueMediawallInternalName = "Internal Name";
    private static final String valueMediawallNumberOfPanels = "3";
    //************ MEDIAWALL OBJECTS ************//

    //************ MEDIAWALL OVERLAY OBJECTS ************//
    private static final String valueMediawallOverlayInternalName = "Internal Name";
    //************ MEDIAWALL OVERLAY OBJECTS ************//

    //************ MEDIAWALL PANEL OBJECTS ************//
    private static final String valueMediawallPanelInternalName = "Internal Name";
    private static final String valueMediawallPanelHeadline = "Headline";
    private static final String valueMediawallPanelURLText = "URL Text";
    private static final String valueMediawallPanelURL = "http://www.milb.com";
    private static final String valueMediawallPanelMobileURL = "http://m.mlb.com";
    private static final String valueMediawallPanelSponsorURL = "http://www.mlb.com";
    private static final String valueMediawallPanelBlurb = "Blurb";
    private static final String valueMediawallPanelNotes = "Notes";
    private static final String valueMediawallPanelDisplayTimeInSeconds = "30";
    private static final String valueMediawallPanelVideoAlias = "Baseball.mov";
    //************ MEDIAWALL PANEL OBJECTS ************//

    //************ MLBTV AD MODULE OBJECTS ************//
    private static final String valueMLBTVAdModuleInternalName = "Internal Name";
    private static final String valueMLBTVAdModuleURL = "http://www.URL.com";
    private static final String valueMLBTVAdModuleMobileURL = "http://m.URL.com";
    private static final String valueMLBTVAdModuleTabletURL = "http://m.tabletURL.com";
    //************ MLBTV AD MODULE OBJECTS ************//

    //************ MOUNDBALL OBJECTS ************//
    private static final String valueMoundBallInternalName = "Internal Name";
    private static final String valueMoundBallBlurb = "Blurb";
    //************ MOUNDBALL OBJECTS ************//

    //************ MUSIC LINK OBJECTS ************//
    private static final String valueMusicLinkInternalName = "Internal Name";
    private static final String valueMusicLinkUniqueID = "Unique ID";
    private static final String valueMusicLinkPreviewURL = "http://www.PreviewURL.com";
    private static final String valueMusicLinkMediaURL = "http://www.MediaURL.com";
    //************ MUSIC LINK OBJECTS ************//

    //************ NOTEBOOK OBJECTS ************//
    private static final String valueNotebookInternalName = "Internal Name";
    private static final String valueNotebookHeadline = "Headline";
    private static final String valueNotebookByline = "Byline";
    private static final String valueNotebookSource = "Source";
    private static final String valueNotebookTagline = "Tagline";
    //************ NOTEBOOK OBJECTS ************//

    //************ PHOTO GALLERY OBJECTS ************//

    private static final String valuePhotoGalleryInternalName = "Internal Name";
    private static final String valuePhotoGalleryTitle = "Title";
    private static final String valuePhotoGallerySpanishTitle = "El Title En Espanol";
    private static final String valuePhotoGalleryBlurb = "Blurb";
    private static final String valuePhotoGallerySpanishBlurb = "El Blurb En Espanol";
    //************ PHOTO GALLERY OBJECTS ************//

    //************ PRESS RELEASE OBJECTS ************//
    private static final String valuePressReleaseInternalName = "Internal Name";
    private static final String valuePressReleaseNotes = "Notes";
    private static final String valuePressReleaseDisplayHeadline = "Display Headline";
    private static final String valuePressReleaseHeadline = "Press Release Headline";
    private static final String valuePressReleaseSubHeadline = "Sub Headline";
    private static final String valuePressReleaseBlurb = "Blurb";
    //************ PRESS RELEASE OBJECTS ************//

    //************ SECTION OBJECTS ************//
    private static final String valueSectionInternalName = "Internal Name";
    private static final String valueSectionSectionID = "1";
    private static final String valueSectionShortTitle = "Short Title";
    private static final String valueSectionLongTitle = "Long Title";
    private static final String valueSectionWiredURL = "http://www.WiredURL.com";
    private static final String valueSectionMobileURL = "http://www.MobileURL.com";
    private static final String valueSectionTarget = "http://www.WiredURL.com";
    private static final String valueSectionType = "http://www.WiredURL.com";
    //************ SECTION OBJECTS ************//

    //************ SOCIAL MEDIA STREAM OBJECTS ************//
    private static final String valueSocialMediaStreamInternalName = "Internal Name";
    private static final String valueSocialMediaStreamDisplayName = "Display Name";
    private static final String valueSocialMediaStreamKey = "Key";
    //************ SOCIAL MEDIA STREAM OBJECTS ************//

    //************ VIDEO TOPIC PAGE OBJECTS ************//
    private static final String valueVideoTopicPageInternalName = "Internal Name";
    private static final String valueVideoTopicPageHeadline = "Headline";
    private static final String valueVideoTopicPageFacebookDescription = "Facebook Description";
    private static final String valueVideoTopicPageMaxItems = "3";
    private static final String valueVideoTopicPageItemsPerPage = "3";
    private static final String valueVideoTopicPageSearchCriteria = "Page Search Criteria";
    private static final String valueVideoTopicPageRelatedLink = "Link";
    private static final String valueVideoTopicPageCustomTemplatePath = "Custom Template Path";
    private static final String valueVideoTopicPageJavascriptPath = "Javascript Path";
    private static final String valueVideoTopicPageStylesheetPath = "Stylesheet Path";
    private static final String valueVideoTopicPageCustomPanel = "Custom Panel";
    private static final String valueVideoTopicPageTwitterHandle = "Twitter Handle";
    private static final String valueVideoTopicPagePollKey = "Poll Key";
    //************ VIDEO TOPIC PAGE OBJECTS ************//

    //************ VIDEO TOPIC PAGE OBJECTS ************//
    private static final String valueVideoClipListInternalName = "Internal Name";
    private static final String valueVideoClipListHeadline = "Headline";
    private static final String valueVideoClipListListDefaultView = "123";
    //************ VIDEO TOPIC PAGE OBJECTS ************//

    //************ TEXT FIELD VALUES ************//
    //************ TEXT FIELD VALUES ************//
    //************ TEXT FIELD VALUES ************//

    //************ MAJOR LEAGUE TESTS ************//
    //************ MAJOR LEAGUE TESTS ************//
    //************ MAJOR LEAGUE TESTS ************//

    private HB_HomePage basePart(){
        HB_HomePage homePage = new HB_HomePage(getDriver());
        homePage.login(loginUser, loginPassword, majorLeagueSiteSelection);
        homePage.oldUIToNewUI(majorLeagueSiteSelection);
        return homePage;
    }

    @Parameters({"month","day","year"})
    @Test
    public void homeBaseTestMLB000TestFunction(String month, int day, int year ) {
        HB_HomePage homePage = basePart();
        homePage.probablesGameContentAddPlayers(month,day,year);
        homePage.probablesGameContentDeletePlayers(month,day,year);
    }

    @Test
    public void homeBaseTestMLB001Login() {
        HB_HomePage homePage = basePart();
    }

    @Test
    public void homeBaseTestMLB002BasicSearch() {
        HB_HomePage homePage = basePart();
        homePage.basicSearch(valueBasicSearch);
    }

    @Test
    public void homeBaseTestMLB003CreateSaveBetaNewArticle() {
        HB_HomePage homePage = basePart();
        homePage.selectNewItem(selectNewItemArticle);
        homePage.fillAndSaveNewArticle(valueBeta, valueArticleInternalName, valueArticleHeadline, valueArticleSubhead, valueArticleAltHeadline, valueArticleByline, valueArticleSeoHeadline, valueArticlePoll, valueMajorTagToolPlayer, valueArticleBlurb, valueArticleNotes, valueArticleTagline);
    }

    @Test
    public void homeBaseTestMLB004CreateSaveBetaNewArticleView() {
        HB_HomePage homePage = basePart();
        homePage.selectNewItem(selectNewItemArticleView);
        homePage.fillAndSaveNewArticleView(valueBeta, valueArticleViewInternalName, valueArticleViewName, valueArticleViewViewKey, valueMajorTagToolPlayer);
    }

    @Test
    public void homeBaseTestMLB005CreateSaveBetaNewAudioSchedule() {
        HB_HomePage homePage = basePart();
        homePage.selectNewItem(selectNewItemAudioSchedule);
        homePage.fillAndSaveNewAudioSchedule(valueBeta, valueAudioScheduleInternalName, valueMajorTagToolPlayer);
    }

    @Test
    public void homeBaseTestMLB006CreateSaveBetaNewBallpark() {
        HB_HomePage homePage = basePart();
        homePage.selectNewItem(selectNewItemBallpark);
        homePage.fillAndSaveNewBallpark(valueBeta, valueBallparkInternalName, valueBallparkID, valueBallparkName, valueBallparkAddress1, valueBallparkAddress2, valueBallparkLocation, valueBallparkMapType, valueBallparkMapVersion, valueBallparkFacebookID, valueBallparkFoursquareID, valueBallparkWebsiteURL, valueBallparkThumbnailURL, valueBallparkThumbnailCaption, valueBallparkTwitterHashTags, valueBallparkAboutURL, valueBallparkScheduleURL, valueBallparkSmallThumbnailURL, valueBallparkStartYear, valueBallparkEndYear, valueBallparkUpgradeURL, valueBallparkAbout, valueBallparkEventsText, valueBallparkSponsorImageText, valueBallparkSponsorImageURL, valueBallparkSponsorImage2Text, valueBallparkSponsorImage2URL, valueBallparkTicketsText, valueBallparkTicketsURL, valueBallparkTicketsErrorText, valueMajorTagToolPlayer);
    }

    @Test
    public void homeBaseTestMLB007CreateSaveBetaNewBallparkMenu() {
        HB_HomePage homePage = basePart();
        homePage.selectNewItem(selectNewItemBallparkMenu);
        homePage.fillAndSaveNewBallparkMenu(valueBeta, valueBallparkMenuInternalName, valueBallparkMenuDisplayName, valueBallparkMenuDisplayImageURL, valueBallparkMenuLinkURL, valueBallparkMenuLinkName, valueBallparkMenuBundleKey, valueBallparkMenuBundleName, valueBallparkMenuBundleURL, valueBallparkMenuSharingURL, valueBallparkMenuSharingText, valueBallparkMenuErrorText, valueBallparkMenuSourceURL, valueMajorTagToolPlayer);
    }

    @Test
    public void homeBaseTestMLB008CreateSaveBetaNewBallparkMusic(){
        HB_HomePage homePage = basePart();
        homePage.selectNewItem(selectNewItemBallparkMusic);
        homePage.fillAndSaveNewBallparkMusic(valueBeta, valueBallparkMusicInternalName, valueBallparkMusicTitle, valueBallparkMusicArtist, valueBallparkMusicDescription, valueBallparkMusicThumbnail, valueBallparkMusicRank, valueMajorTagToolPlayer);
    }

    @Test
    public void homeBaseTestMLB009CreateSaveBetaNewBallparkSubmenu()  {
        HB_HomePage homePage = basePart();
        homePage.selectNewItem(selectNewItemBallparkSubmenu);
        homePage.fillAndSaveNewBallparkSubmenu(valueBeta, valueBallparkMenuInternalName, valueBallparkMenuDisplayName, valueBallparkMenuDisplayImageURL, valueBallparkMenuLinkURL, valueBallparkMenuLinkName, valueBallparkMenuBundleKey, valueBallparkMenuBundleName, valueBallparkMenuBundleURL, valueBallparkMenuSharingURL, valueBallparkMenuSharingText, valueBallparkMenuErrorText, valueBallparkMenuSourceURL, valueMajorTagToolPlayer);
    }

    @Test
    public void homeBaseTestMLB010CreateSaveBetaNewBlogContent()  {
        HB_HomePage homePage = basePart();
        homePage.selectNewItem(selectNewItemBlogContent);
        homePage.fillAndSaveNewBlogContent(valueBeta, valueBlogContentInternalName, valueBlogContentURL, valueBlogContentURLText, valueBlogContentHeadline, valueBlogContentAltHeadline, valueBlogContentSEOHeadline, valueBlogContentBlurb, valueBlogContentByline, valueBlogContentCaption, valueBlogContentMediaCredit, valueMajorTagToolPlayer);
    }

    @Test
    public void homeBaseTestMLB011CreateSaveBetaNewBlogContentAlias()  {
        HB_HomePage homePage = basePart();
        homePage.selectNewItem(selectNewItemBlogContentAlias);
        homePage.fillAndSaveNewBlogContentAlias(valueBeta, valueBlogContentAliasInternalName, valueBlogContentAliasHeadline, valueBlogContentAliasBlurb, valueBlogContentAliasSummary);
    }

    @Test
    public void homeBaseTestMLB012CreateSaveBetaNewChron()  {
        HB_HomePage homePage = basePart();
        homePage.selectNewItem(selectNewItemChron);
        homePage.fillAndSaveNewChron(valueBeta, valueChronInternalName, valueChronDateNotation, valueChronYear, valueChronDisplayYear, valueChronTitle, valueMajorTagToolPlayer);
    }

    @Test
    public void homeBaseTestMLB013CreateSaveBetaNewClosedCaption()  {
        HB_HomePage homePage = basePart();
        homePage.selectNewItem(selectNewItemClosedCaption);
        homePage.fillAndSaveNewClosedCaption(valueBeta, valueClosedCaptionInternalName, valueMajorTagToolPlayer);
    }

    @Test
    public void homeBaseTestMLB014CreateSaveBetaNewClubPromo()  {
        HB_HomePage homePage = basePart();
        homePage.selectNewItem(selectNewItemClubPromo);
        homePage.fillAndSaveNewClubPromo(valueBeta, valueClubPromoInternalName, valueClubPromoURLExtension, valueClubPromoEventTitle, valueClubPromoEventSubtitle, valueClubPromoPromoText, valueClubPromoMobileTicketsText, valueClubPromoMobileTicketsURL, valueClubPromoTicketsURL, valueClubPromoTextCampaignPromo, valueClubPromoSocialKeyword, valueClubPromoHighlightsTitle, valueClubPromoLocationAddress, valueClubPromoEventMapTitle, valueClubPromoScheduleTitle, valueClubPromoFAQTitle, valueMajorTagToolPlayer);
    }

    @Test
    public void homeBaseTestMLB015CreateSaveBetaNewContributor()  {
        HB_HomePage homePage = basePart();
        homePage.selectNewItem(selectNewItemContributor);
        homePage.fillAndSaveNewContributor(valueBeta, valueContributorInternalName, valueContributorFirstName, valueContributorLastName, valueContributorTitle, valueContributorEmail, valueContributorTwitterHandle, valueContributorBlog, valueContributorBlogTitle, valueContributorRSSFeed, valueContributorFacebookID, valueContributorActiveTab, valueContributorHideArticles, valueContributorVideoKeywordType, valueContributorVideoKeywordValue, valueContributorVideoLandingPage, valueContributorBlurb, valueMajorTagToolPlayer);
    }

    @Test
    public void homeBaseTestMLB016CreateSaveBetaNewDailyEmail()  {
        HB_HomePage homePage = basePart();
        homePage.selectNewItem(selectNewItemDailyEmail);
        homePage.fillAndSaveNewDailyEmail(valueBeta, valueDailyEmailInternalName, valueDailyEmailSubject, valueDailyEmailSubjectB, valueDailyEmailTriviaQuestion, valueDailyEmailTriviaAnswer, valueMajorTagToolPlayer);
    }

    @Test
    public void homeBaseTestMLB017CreateSaveBetaNewDeviceAnnouncement()  {
        HB_HomePage homePage = basePart();
        homePage.selectNewItem(selectNewItemDeviceAnnouncement);
        homePage.fillAndSaveNewDeviceAnnouncement(valueBeta, valueDeviceAnnouncementInternalName, valueDeviceAnnouncementAppVersion, valueDeviceAnnouncementOSVersion, valueDeviceAnnouncementEntitlement, valueDeviceAnnouncementScreen, valueDeviceAnnouncementType, valueDeviceAnnouncementDisplayType, valueDeviceAnnouncementTitle, valueDeviceAnnouncementMessage, valueDeviceAnnouncementOpenLabel, valueDeviceAnnouncementOpenLink, valueDeviceAnnouncementCloseLabel, valueDeviceAnnouncementCloseLink, valueMajorTagToolPlayer);
    }

    @Test
    public void homeBaseTestMLB018CreateSaveBetaNewDeviceBanner()  {
        HB_HomePage homePage = basePart();
        homePage.selectNewItem(selectNewItemDeviceBanner);
        homePage.fillAndSaveNewDeviceBanner(valueBeta, valueDeviceBannerInternalName, valueDeviceBannerAppVersion, valueDeviceBannerOSVersion, valueDeviceBannerEntitlement, valueDeviceBannerAccessFeature, valueDeviceBannerScreen, valueDeviceBannerViewID, valueDeviceBannerType, valueDeviceBannerWebViewType, valueDeviceAnnouncementTitle, valueDeviceBannerLink, valueDeviceBannerBackgroundColor, valueDeviceBannerTrackingString, valueDeviceBannerAdMarvelID, valueDeviceBannerAdMarvelWidth, valueDeviceBannerAdMarvelHeight, valueDeviceBannerAdMarvelSectionID, valueDeviceBannerAdMarvelMLBTarget, valueDeviceBannerAdMarvelExpiryTime, valueDeviceBannerMLBTVContentID, valueDeviceBannerMLBTVCalendarEventID, valueDeviceBannerSponsor, valueMajorTagToolPlayer);
    }

    @Test
    public void homeBaseTestMLB019CreateSaveBetaNewDevicePage()  {
        HB_HomePage homePage = basePart();
        homePage.selectNewItem(selectNewItemDevicePage);
        homePage.fillAndSaveNewDevicePage(valueBeta, valueDevicePageInternalName, valueDevicePageHeadline, valueDevicePageBlurb, valueDevicePageYearlyPurchaseFlow, valueDevicePageMonthlyPurchaseFlow, valueDevicePageUpgradeLink, valueDevicePageActivationLink, valueMajorTagToolPlayer);
    }

    //	@Test
    public void homeBaseTestMLB020CreateSaveBetaNewDigitalAsset()  {
        HB_HomePage homePage = basePart();
        homePage.selectNewItem(selectNewItemDigitalAsset);
        homePage.fillAndSaveNewDigitalAsset(valueBeta, valueDigitalAssetInternalName, valueDigitalAssetHeadline, valueMajorTagToolPlayer);
    }

    @Test
    public void homeBaseTestMLB021CreateSaveBetaNewDrawer()  {
        HB_HomePage homePage = basePart();
        homePage.selectNewItem(selectNewItemDrawer);
        homePage.fillAndSaveNewDrawer(mainURL, valueBeta, valueDrawerInternalName, valueDrawerKicker, valueDrawerCustomContent, valueDrawerBlurb, valueDrawerURL, valueDrawerURLText, valueDrawerNumberOfItems, valueMajorTagToolPlayer);
    }

    @Test
    public void homeBaseTestMLB022CreateSaveBetaNewEvent()  {
        HB_HomePage homePage = basePart();
        homePage.selectNewItem(selectNewItemEvent);
        homePage.fillAndSaveNewEvent(mainURL, valueBeta, valueEventInternalName, valueEventProgramID, valueEventProgram, valueEventLocation, valueEventEventTitle, valueEventDescription, valueEventURL, valueMajorTagToolPlayer);
    }

    @Test
    public void homeBaseTestMLB023CreateSaveBetaNewFeature()  {
        HB_HomePage homePage = basePart();
        homePage.selectNewItem(selectNewItemFeature);
        homePage.fillAndSaveNewFeature(valueBeta, valueFeatureInternalName, valueFeatureHeadline, valueFeatureURL, valueFeatureURLText, valueFeatureMobileURL, valueFeatureBlurb, valueMajorTagToolPlayer);
    }

    @Test
    public void homeBaseTestMLB024CreateSaveBetaNewFeatures()  {
        HB_HomePage homePage = basePart();
        homePage.selectNewItem(selectNewItemFeatures);
        homePage.fillAndSaveNewFeatures(valueBeta, valueFeaturesInternalName, valueFeaturesNumberOfItems, valueMajorTagToolPlayer);
    }

    @Test
    public void homeBaseTestMLB025CreateSaveBetaNewFieldOption()  {
        HB_HomePage homePage = basePart();
        homePage.selectNewItem(selectNewItemFieldOption);
        homePage.fillAndSaveNewFieldOption(valueBeta, valueFieldOptionInternalName, valueFieldOptionDisplayName, valueFieldOptionValue, valueMajorTagToolPlayer);
    }

    @Test
    public void homeBaseTestMLB026CreateSaveBetaNewGamePreview()  {
        HB_HomePage homePage = basePart();
        homePage.selectNewItem(selectNewItemGamePreview);
        homePage.fillAndSaveNewGamePreview(valueBeta, valueGamePreviewInternalName, valueGamePreviewHeadline, valueGamePreviewHomeHeadline, valueGamePreviewAwayHeadline, valueGamePreviewSubhead, valueGamePreviewAltHeadline, valueGamePreviewByline, valueGamePreviewBlurb, valueMajorTagToolPlayer);
    }

    @Test
    public void homeBaseTestMLB027CreateSaveBetaNewGameWrap()  {
        HB_HomePage homePage = basePart();
        homePage.selectNewItem(selectNewItemGameWrap);
        homePage.fillAndSaveNewGameWrap(valueBeta, valueGameWrapInternalName, valueGameWrapHeadline, valueGameWrapBlurb, valueMajorTagToolPlayer);
    }

    @Test
    public void homeBaseTestMLB028CreateSaveBetaNewHighlight()  {
        HB_HomePage homePage = basePart();
        homePage.selectNewItem(selectNewItemHighlight);
        homePage.fillAndSaveNewHighlight(valueBeta, valueHighlightInternalName, valueHighlightYear, valueMajorTagToolPlayer);
    }

    @Test
    public void homeBaseTestMLB029CreateSaveBetaNewHomepageTab()  {
        HB_HomePage homePage = basePart();
        homePage.selectNewItem(selectNewItemHomepageTab);
        homePage.fillAndSaveNewHomepageTab(valueBeta, valueHomepageTabInternalName, valueHomepageTabDefaultAltText, valueHomepageTabDefaultClickthroughURL, valueMajorTagToolPlayer);
    }

    @Test
    public void homeBaseTestMLB030CreateSaveBetaNewHPConfig()  {
        HB_HomePage homePage = basePart();
        homePage.selectNewItem(selectNewItemHPConfig);
        homePage.fillAndSaveNewHPConfig(valueBeta, valueHPConfigInternalName, valueHPConfigBreakingNews, valueHPConfigBreakingNewsURL, valueHPConfigABTests, valueHPConfigHeaderURL, valueHPConfigHeaderAlt, valueMajorTagToolPlayer);
    }

    @Test
    public void homeBaseTestMLB031CreateSaveBetaNewHTMLInclude()  {
        HB_HomePage homePage = basePart();
        homePage.selectNewItem(selectNewItemIncludeHTML);
        homePage.fillAndSaveNewHTMLInclude(valueBeta, valueHTMLIncludeInternalName, valueMajorTagToolPlayer);
    }

    @Test
    public void homeBaseTestMLB032CreateSaveBetaNewInstagramPhoto()  {
        HB_HomePage homePage = basePart();
        homePage.selectNewItem(selectNewItemInstagramPhoto);
        homePage.fillAndSaveNewInstagramPhoto(valueBeta, valueInstagramPhotoInternalName, valueInstagramPhotoApprover, valueInstagramPhotoApprovedTime, valueInstagramPhotoInstagramID, valueInstagramPhotoImageURL, valueInstagramPhotoLargeImageURL, valueInstagramPhotoCaption, valueInstagramPhotoCreatorID, valueInstagramPhotoCreatorName, valueInstagramPhotoCreatorProfilePicture, valueInstagramPhotoCreatedTime, valueInstagramPhotoLatitude, valueInstagramPhotoLongitude, valueMajorTagToolPlayer);
    }

    @Test
    public void homeBaseTestMLB033CreateSaveBetaNewSocialMediaStream()  {
        HB_HomePage homePage = basePart();
        homePage.selectNewItem(selectNewItemSocialMediaStream);
        homePage.fillAndSaveNewSocialMediaStream(valueBeta, valueSocialMediaStreamInternalName, valueSocialMediaStreamDisplayName, valueSocialMediaStreamKey, valueMajorTagToolPlayer);
    }

    @Test
    public void homeBaseTestMLB034CreateSaveBetaNewKiosk()  {
        HB_HomePage homePage = basePart();
        homePage.selectNewItem(selectNewItemKiosk);
        homePage.fillAndSaveNewKiosk(valueBeta, valueKioskInternalName, valueKioskCalendarEventID, valueKioskContentID, valueMajorTagToolPlayer);
    }

    @Test
    public void homeBaseTestMLB035CreateSaveBetaNewLineup()  {
        HB_HomePage homePage = basePart();
        homePage.selectNewItem(selectNewItemLineup);
        homePage.fillAndSaveNewLineup(valueBeta, valueLineupInternalName, valueLineupUmpireHP, valueLineupUmpire1st, valueLineupUmpire2nd, valueLineupUmpire3rd, valueLineupUmpireLF, valueLineupUmpireRF, valueLineupUmpireOS, valueLineupNotes, valueMajorTagToolPlayer);
    }

    @Test
    public void homeBaseTestMLB036CreateSaveBetaNewLineupPlayer()  {
        HB_HomePage homePage = basePart();
        homePage.selectNewItem(selectNewItemLineupPlayer);
        homePage.fillAndSaveNewLineupPlayer(valueBeta, valueLineupPlayerInternalName, valueLineupPlayerPosition, valueMajorTagToolPlayer);
    }

    @Test
    public void homeBaseTestMLB037CreateSaveBetaNewLink()  {
        HB_HomePage homePage = basePart();
        homePage.selectNewItem(selectNewItemLink);
        homePage.fillAndSaveNewLink(valueBeta, valueLinkInternalName, valueLinkLinkText, valueLinkLinkURL, valueLinkWidth, valueLinkHeight, valueMajorTagToolPlayer);
    }

    @Test
    public void homeBaseTestMLB038CreateSaveBetaNewList()  {
        HB_HomePage homePage = basePart();
        homePage.selectNewItem(selectNewItemList);
        homePage.fillAndSaveNewList(valueBeta, valueListInternalName, valueListKey, valueListNumberOfItems, valueListBlurb, valueMajorTagToolPlayer);
    }

    @Test
    public void homeBaseTestMLB039CreateSaveBetaNewMediawall()  {
        HB_HomePage homePage = basePart();
        homePage.selectNewItem(selectNewItemMediawall);
        homePage.fillAndSaveNewMediawall(valueBeta, valueMediawallInternalName, valueMediawallNumberOfPanels, valueMajorTagToolPlayer);
    }

    @Test
    public void homeBaseTestMLB040CreateSaveBetaNewMediawallOverlay()  {
        HB_HomePage homePage = basePart();
        homePage.selectNewItem(selectNewItemMediawallOverlay);
        homePage.fillAndSaveNewMediawallOverlay(valueBeta, valueMediawallOverlayInternalName, valueMajorTagToolPlayer);
    }

    @Test
    public void homeBaseTestMLB041CreateSaveBetaNewMediaWallPanel()  {
        HB_HomePage homePage = basePart();
        homePage.selectNewItem(selectNewItemMediawallPanel);
        homePage.fillAndSaveNewMediaWallPanel(valueBeta, valueMediawallPanelInternalName, valueMediawallPanelHeadline, valueMediawallPanelURLText, valueMediawallPanelURL, valueMediawallPanelMobileURL, valueMediawallPanelSponsorURL, valueMediawallPanelBlurb, valueMediawallPanelNotes, valueMediawallPanelDisplayTimeInSeconds, valueMediawallPanelVideoAlias, valueMajorTagToolPlayer);
    }

    @Test
    public void homeBaseTestMLB042CreateSaveBetaNewMLBTVAdModule()  {
        HB_HomePage homePage = basePart();
        homePage.selectNewItem(selectNewItemMLBTVAdModule);
        homePage.fillAndSaveNewMLBTVAdModule(valueBeta, valueMLBTVAdModuleInternalName, valueMLBTVAdModuleURL, valueMLBTVAdModuleMobileURL, valueMLBTVAdModuleTabletURL, valueMajorTagToolPlayer);
    }

    @Test
    public void homeBaseTestMLB043CreateSaveBetaNewMoundBall()  {
        HB_HomePage homePage = basePart();
        homePage.selectNewItem(selectNewItemMoundBall);
        homePage.fillAndSaveNewMoundBall(valueBeta, valueMoundBallInternalName, valueMoundBallBlurb, valueMajorTagToolPlayer);
    }

    @Test
    public void homeBaseTestMLB044CreateSaveBetaNewMusicLink()  {
        HB_HomePage homePage = basePart();
        homePage.selectNewItem(selectNewItemMusicLink);
        homePage.fillAndSaveNewMusicLink(valueBeta, valueMusicLinkInternalName, valueMusicLinkUniqueID, valueMusicLinkPreviewURL, valueMusicLinkMediaURL, valueMajorTagToolPlayer);
    }

    @Test
    public void homeBaseTestMLB045CreateSaveBetaNewNote()  {
        HB_HomePage homePage = basePart();
        homePage.selectNewItem(selectNewItemNote);
        homePage.fillAndSaveNewNote(valueBeta, valueAudioScheduleInternalName, valueMajorTagToolPlayer);
    }

    @Test
    public void homeBaseTestMLB046CreateSaveBetaNewNotebook()  {
        HB_HomePage homePage = basePart();
        homePage.selectNewItem(selectNewItemNotebook);
        homePage.fillAndSaveNewNotebook(valueBeta, valueNotebookInternalName, valueNotebookHeadline, valueNotebookByline, valueNotebookSource, valueNotebookTagline, valueMajorTagToolPlayer);
    }

    @Test
    public void homeBaseTestMLB047CreateSaveBetaNewPage()  {
        HB_HomePage homePage = basePart();
        homePage.selectNewItem(selectNewItemPage);
        homePage.fillAndSaveNewPage(valueBeta, valueAudioScheduleInternalName, valueMajorTagToolPlayer);
    }

    @Test
    public void homeBaseTestMLB048CreateSaveBetaNewPhotoGallery()  {
        HB_HomePage homePage = basePart();
        homePage.selectNewItem(selectNewItemPhotoGallery);
        homePage.fillAndSaveNewPhotoGallery(valueBeta, valuePhotoGalleryInternalName, valuePhotoGalleryTitle, valuePhotoGallerySpanishTitle, valuePhotoGalleryBlurb, valuePhotoGallerySpanishBlurb, valueMajorTagToolPlayer);
    }

    @Test
    public void homeBaseTestMLB049CreateSaveBetaNewPhotoGalleryAlias()  {
        HB_HomePage homePage = basePart();
        homePage.selectNewItem(selectNewItemPhotoGalleryAlias);
        homePage.fillAndSaveNewPhotoGalleryAlias(valueBeta, valueAudioScheduleInternalName);
    }

    @Test
    public void homeBaseTestMLB050CreateSaveBetaNewPhotoGalleryList()  {
        HB_HomePage homePage = basePart();
        homePage.selectNewItem(selectNewItemPhotoGalleryList);
        homePage.fillAndSaveNewPhotoGalleryList(valueBeta, valueAudioScheduleInternalName, valueMajorTagToolPlayer);
    }

    @Test
    public void homeBaseTestMLB051CreateSaveBetaNewProspect()  {
        HB_HomePage homePage = basePart();
        homePage.selectNewItem(selectNewItemPlayerProspect);
        homePage.fillAndSaveNewProspect(valueBeta, valueAudioScheduleInternalName, valueMajorTagToolPlayer);
    }

    @Test
    public void homeBaseTestMLB052CreateSaveBetaNewPodcastDetail()  {
        HB_HomePage homePage = basePart();
        homePage.selectNewItem(selectNewItemPodcastDetail);
        homePage.fillAndSaveNewPodcastDetail(valueBeta, valueAudioScheduleInternalName, valueMajorTagToolPlayer);
    }

    @Test
    public void homeBaseTestMLB053CreateSaveBetaNewPodcastEpisode()  {
        HB_HomePage homePage = basePart();
        homePage.selectNewItem(selectNewItemPodcastEpisode);
        homePage.fillAndSaveNewPodcastEpisode(valueBeta, valueAudioScheduleInternalName, valueMajorTagToolPlayer);
    }

    @Test
    public void homeBaseTestMLB054CreateSaveBetaNewPressRelease()  {
        HB_HomePage homePage = basePart();
        homePage.selectNewItem(selectNewItemPressRelease);
        homePage.fillAndSaveNewPressRelease(valueBeta, valuePressReleaseInternalName, valuePressReleaseNotes, valuePressReleaseDisplayHeadline, valuePressReleaseHeadline, valuePressReleaseSubHeadline, valuePressReleaseBlurb, valueMajorTagToolPlayer);
    }

    @Test
    public void homeBaseTestMLB055CreateSaveBetaNewPressboxAsset()  {
        HB_HomePage homePage = basePart();
        homePage.selectNewItem(selectNewItemPressboxAsset);
        homePage.fillAndSaveNewPressboxAsset(valueBeta, valueAudioScheduleInternalName, valueMajorTagToolPlayer);
    }

    @Test
    public void homeBaseTestMLB056CreateSaveBetaNewPressboxAssetList()  {
        HB_HomePage homePage = basePart();
        homePage.selectNewItem(selectNewItemPressboxAssetList);
        homePage.fillAndSaveNewPressboxAssetList(valueBeta, valueAudioScheduleInternalName, valueMajorTagToolPlayer);
    }

    @Test
    public void homeBaseTestMLB057CreateSaveBetaNewPreviewAlias()  {
        HB_HomePage homePage = basePart();
        homePage.selectNewItem(selectNewItemPreviewAlias);
        homePage.fillAndSaveNewPreviewAlias(valueBeta, valueAudioScheduleInternalName);
    }

    @Test
    public void homeBaseTestMLB058CreateSaveBetaNewProgramShow()  {
        HB_HomePage homePage = basePart();
        homePage.selectNewItem(selectNewItemProgramShow);
        homePage.fillAndSaveNewProgramShow(valueBeta, valueAudioScheduleInternalName, valueMajorTagToolPlayer);
    }

    @Test
    public void homeBaseTestMLB059CreateSaveBetaNewPromoApplication() {
        HB_HomePage homePage = basePart();
        homePage.selectNewItem(selectNewItemPromoApplication);
        homePage.fillAndSaveNewPromoApplication(valueBeta, valueAudioScheduleInternalName, valueMajorTagToolPlayer);
    }

    @Test
    public void homeBaseTestMLB060CreateSaveBetaNewQuoteSheet()  {
        HB_HomePage homePage = basePart();
        homePage.selectNewItem(selectNewItemQuoteSheet);
        homePage.fillAndSaveNewQuoteSheet(valueBeta, valueAudioScheduleInternalName, valueMajorTagToolPlayer);
    }

    @Test
    public void homeBaseTestMLB061CreateSaveBetaNewRaffle() {
        HB_HomePage homePage = basePart();
        homePage.selectNewItem(selectNewItemRaffle);
        homePage.fillAndSaveNewRaffle(valueBeta, valueAudioScheduleInternalName, valueMajorTagToolPlayer);
    }

    @Test
    public void homeBaseTestMLB062CreateSaveBetaNewSchedule(){
        HB_HomePage homePage = basePart();
        homePage.selectNewItem(selectNewItemSchedule);
        homePage.fillAndSaveNewSchedule(valueBeta, valueAudioScheduleInternalName, valueMajorTagToolPlayer);
    }

    @Test
    public void homeBaseTestMLB063CreateSaveBetaNewScrapbook() {
        HB_HomePage homePage = basePart();
        homePage.selectNewItem(selectNewItemScrapbook);
        homePage.fillAndSaveNewScrapbook(valueBeta, valueAudioScheduleInternalName, valueMajorTagToolPlayer);
    }

    @Test
    public void homeBaseTestMLB064CreateSaveBetaNewScrapbookPage() {
        HB_HomePage homePage = basePart();
        homePage.selectNewItem(selectNewItemScrapbookPage);
        homePage.fillAndSaveNewScrapbookPage(valueBeta, valueAudioScheduleInternalName, valueMajorTagToolPlayer);
    }

    @Test
    public void homeBaseTestMLB065CreateSaveBetaNewSection() {
        HB_HomePage homePage = basePart();
        homePage.selectNewItem(selectNewItemSection);
        homePage.fillAndSaveNewSection(valueBeta, valueSectionInternalName, valueSectionSectionID, valueSectionShortTitle, valueSectionLongTitle, valueSectionWiredURL, valueSectionMobileURL, valueSectionTarget, valueSectionType, valueMajorTagToolPlayer);
    }

    @Test
    public void homeBaseTestMLB066CreateSaveBetaNewSeriesConfiguration() {
        HB_HomePage homePage = basePart();
        homePage.selectNewItem(selectNewItemSeriesConfiguration);
        homePage.fillAndSaveNewSeriesConfiguration(valueBeta, valueAudioScheduleInternalName, valueMajorTagToolPlayer);
    }

    @Test
    public void homeBaseTestMLB067CreateSaveBetaNewShortContent(){
        HB_HomePage homePage = basePart();
        homePage.selectNewItem(selectNewItemShortContent);
        homePage.fillAndSaveNewShortContent(valueBeta, valueAudioScheduleInternalName, valueMajorTagToolPlayer);
    }

    @Test
    public void homeBaseTestMLB068CreateSaveBetaNewTicketPage() {
        HB_HomePage homePage = basePart();
        homePage.selectNewItem(selectNewItemTicketPage);
        homePage.fillAndSaveNewTicketPage(valueBeta, valueAudioScheduleInternalName, valueMajorTagToolPlayer);
    }

    @Test
    public void homeBaseTestMLB069CreateSaveBetaNewTrendingModule()  {
        HB_HomePage homePage = basePart();
        homePage.selectNewItem(selectNewItemTrendingModule);
        homePage.fillAndSaveNewTrendingModule(valueBeta, valueAudioScheduleInternalName, valueMajorTagToolPlayer);
    }

    @Test
    public void homeBaseTestMLB070CreateSaveBetaNewTweet()  {
        HB_HomePage homePage = basePart();
        homePage.selectNewItem(selectNewItemTweet);
        homePage.fillAndSaveNewTweet(valueBeta, valueAudioScheduleInternalName, valueMajorTagToolPlayer);
    }

    @Test
    public void homeBaseTestMLB071CreateSaveBetaNewVideoTopicPage() {
        HB_HomePage homePage = basePart();
        homePage.selectNewItem(selectNewItemVideoTopicPage);
        homePage.fillAndSaveNewVideoTopicPage(valueBeta, valueVideoTopicPageInternalName, valueVideoTopicPageHeadline, valueVideoTopicPageFacebookDescription, valueVideoTopicPageMaxItems, valueVideoTopicPageItemsPerPage, valueVideoTopicPageSearchCriteria, valueVideoTopicPageRelatedLink, valueVideoTopicPageCustomTemplatePath, valueVideoTopicPageJavascriptPath, valueVideoTopicPageStylesheetPath, valueVideoTopicPageCustomPanel, valueVideoTopicPageTwitterHandle, valueVideoTopicPagePollKey, valueMajorTagToolPlayer);
    }

    @Test
    public void homeBaseTestMLB072CreateSaveBetaNewTwitterHandle(){
        HB_HomePage homePage = basePart();
        homePage.selectNewItem(selectNewItemTwitterHandle);
        homePage.fillAndSaveNewTwitterHandle(valueBeta, valueAudioScheduleInternalName, valueMajorTagToolPlayer);
    }

    @Test
    public void homeBaseTestMLB073CreateSaveBetaNewVideoClipList() {
        HB_HomePage homePage = basePart();
        homePage.selectNewItem(selectNewItemVideoClipList);
        homePage.fillAndSaveNewVideoClipList(valueBeta, valueVideoClipListInternalName, valueVideoClipListHeadline, valueVideoClipListListDefaultView, valueMajorTagToolPlayer);
    }

    @Test
    public void homeBaseTestMLB074UploadPhotos(){
        HB_HomePage homePage = basePart();
        homePage.selectHomePageUploadPhotos();
        homePage.uploadPhotos();
    }

    @Test
    public void homeBaseTestMLB075DepthChart()  {
        HB_HomePage homePage = basePart();
        homePage.depthChartsAddPlayers();
        homePage.depthChartsRepositionPlayers();
        homePage.depthChartsDeletePlayers();
    }
    @Parameters({"month","day","year"})
    @Test
    public void homeBaseTestMLB076TeamContentProbables(String month, int day, int year){
        HB_HomePage homePage = basePart();
        homePage.probablesTeamContentAddPlayers(month,day,year);
        homePage.probablesTeamContentRepositionPlayers(month,day,year);
        homePage.probablesTeamContentDeletePlayers(month,day,year);
    }
    @Parameters({"month","day","year"})
    @Test
    public void homeBaseTestMLB077GameContentProbables(String month, int day, int year) {
        HB_HomePage homePage = basePart();
        homePage.probablesGameContentAddPlayers(month,day,year);
        homePage.probablesGameContentDeletePlayers(month,day,year);
    }

    @Parameters({"month","day","year"})
    @Test
    public void homeBaseTestMLB078GameContentLineup(String month, int day, int year) {
        HB_HomePage homePage = basePart();
        homePage.lineupGameContentBaseState(month,day,year);
        homePage.lineupGameContentDeletePlayers();
        homePage.lineupGameContentAddPlayers();
        //homePage.lineupGameContentDeletePlayers();
    }


    //************ MAJOR LEAGUE TESTS ************//
    //************ MAJOR LEAGUE TESTS ************//
    //************ MAJOR LEAGUE TESTS ************//


    //************ MINOR LEAGUE TESTS ************//
    //************ MINOR LEAGUE TESTS ************//
    //************ MINOR LEAGUE TESTS ************//

    @Test
    public void homeBaseTestMiLB001Login(){
        HB_HomePage homePage = new HB_HomePage(getDriver());
        homePage.login(loginUser, loginPassword, minorLeagueSiteSelection);
        homePage.oldUIToNewUI(minorLeagueSiteSelection);
    }

    @Test
    public void homeBaseTestMiLB002BasicSearch(){
        HB_HomePage homePage = new HB_HomePage(getDriver());
        homePage.login(loginUser, loginPassword, minorLeagueSiteSelection);
        homePage.oldUIToNewUI(minorLeagueSiteSelection);
        homePage.basicSearch(valueBasicSearch);
    }

    @Test
    public void homeBaseTestMiLB003CreateSaveBetaNewArticle(){
        HB_HomePage homePage = new HB_HomePage(getDriver());
        homePage.login(loginUser, loginPassword, minorLeagueSiteSelection);
        homePage.oldUIToNewUI(minorLeagueSiteSelection);
        homePage.selectNewItem(selectNewItemArticle);
        homePage.fillAndSaveNewArticle(valueBeta, valueArticleInternalName, valueArticleHeadline, valueArticleSubhead, valueArticleAltHeadline, valueArticleByline, valueArticleSeoHeadline, valueArticlePoll, valueMinorTagToolPlayer, valueArticleBlurb, valueArticleNotes, valueArticleTagline);
    }

    @Test
    public void homeBaseTestMiLB004CreateSaveBetaNewDigitalAsset(){
        HB_HomePage homePage = new HB_HomePage(getDriver());
        homePage.login(loginUser, loginPassword, minorLeagueSiteSelection);
        homePage.oldUIToNewUI(minorLeagueSiteSelection);
        homePage.selectNewItem(selectNewItemDigitalAsset);
        homePage.fillAndSaveNewDigitalAsset(valueBeta, valueDigitalAssetInternalName, valueDigitalAssetHeadline, valueMinorTagToolPlayer);
    }

    @Test
    public void homeBaseTestMiLB005CreateSaveBetaNewFieldOption(){
        HB_HomePage homePage = new HB_HomePage(getDriver());
        homePage.login(loginUser, loginPassword, minorLeagueSiteSelection);
        homePage.oldUIToNewUI(minorLeagueSiteSelection);
        homePage.selectNewItem(selectNewItemFieldOption);
        homePage.fillAndSaveNewFieldOption(valueBeta, valueFieldOptionInternalName, valueFieldOptionDisplayName, valueFieldOptionValue, valueMinorTagToolPlayer);
    }

    @Test
    public void homeBaseTestMiLB006CreateSaveBetaNewHighlight(){
        HB_HomePage homePage = new HB_HomePage(getDriver());
        homePage.login(loginUser, loginPassword, minorLeagueSiteSelection);
        homePage.oldUIToNewUI(minorLeagueSiteSelection);
        homePage.selectNewItem(selectNewItemHighlight);
        homePage.fillAndSaveNewHighlight(valueBeta, valueHighlightInternalName, valueHighlightYear, valueMinorTagToolPlayer);
    }

    @Test
    public void homeBaseTestMiLB007CreateSaveBetaNewHTMLPage() {
        HB_HomePage homePage = new HB_HomePage(getDriver());
        homePage.login(loginUser, loginPassword, minorLeagueSiteSelection);
        homePage.oldUIToNewUI(minorLeagueSiteSelection);
        homePage.selectNewItem(selectNewItemHTMLPage);
        homePage.fillAndSaveNewHTMLPage(valueBeta, valueHTMLPageInternalName, valueHTMLPageHeadline, valueHTMLPageBlurb, valueMinorTagToolPlayer);
    }

    @Test
    public void homeBaseTestMiLB008CreateSaveBetaNewLink(){
        HB_HomePage homePage = new HB_HomePage(getDriver());
        homePage.login(loginUser, loginPassword, minorLeagueSiteSelection);
        homePage.oldUIToNewUI(minorLeagueSiteSelection);
        homePage.selectNewItem(selectNewItemLink);
        homePage.fillAndSaveNewLink(valueBeta, valueLinkInternalName, valueLinkLinkText, valueLinkLinkURL, valueLinkWidth, valueLinkHeight, valueMinorTagToolPlayer);
    }

    @Test
    public void homeBaseTestMiLB009CreateSaveBetaNewMediaWallPanel() {
        HB_HomePage homePage = new HB_HomePage(getDriver());
        homePage.login(loginUser, loginPassword, minorLeagueSiteSelection);
        homePage.oldUIToNewUI(minorLeagueSiteSelection);
        homePage.selectNewItem(selectNewItemMediawallPanel);
        homePage.fillAndSaveNewMediaWallPanel(valueBeta, valueMediawallPanelInternalName, valueMediawallPanelHeadline, valueMediawallPanelURLText, valueMediawallPanelURL, valueMediawallPanelMobileURL, valueMediawallPanelSponsorURL, valueMediawallPanelBlurb, valueMediawallPanelNotes, valueMediawallPanelDisplayTimeInSeconds, valueMediawallPanelVideoAlias, valueMinorTagToolPlayer);
    }

    @Test
    public void homeBaseTestMiLB010CreateSaveBetaNewNotebook()  {
        HB_HomePage homePage = new HB_HomePage(getDriver());
        homePage.login(loginUser, loginPassword, minorLeagueSiteSelection);
        homePage.oldUIToNewUI(minorLeagueSiteSelection);
        homePage.selectNewItem(selectNewItemNotebook);
        homePage.fillAndSaveNewNotebook(valueBeta, valueNotebookInternalName, valueNotebookHeadline, valueNotebookByline, valueNotebookSource, valueNotebookTagline, valueMinorTagToolPlayer);
    }

    @Test
    public void homeBaseTestMiLB011CreateSaveBetaNewPhotoGallery(){
        HB_HomePage homePage = new HB_HomePage(getDriver());
        homePage.login(loginUser, loginPassword, minorLeagueSiteSelection);
        homePage.oldUIToNewUI(minorLeagueSiteSelection);
        homePage.selectNewItem(selectNewItemPhotoGallery);
        homePage.fillAndSaveNewPhotoGallery(valueBeta, valuePhotoGalleryInternalName, valuePhotoGalleryTitle, valuePhotoGallerySpanishTitle, valuePhotoGalleryBlurb, valuePhotoGallerySpanishBlurb, valueMinorTagToolPlayer);
    }

    //************ MINOR LEAGUE TESTS ************//
    //************ MINOR LEAGUE TESTS ************//
    //************ MINOR LEAGUE TESTS ************//


}
