package com.mlb.qa.tests.web.homebase;

import java.awt.AWTException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.testng.annotations.Test;

import com.mlb.qa.gui.pages.homebaseproject.HB_HomePage;
import com.qaprosoft.carina.core.foundation.UITest;

public class HomebaseTestSuite extends UITest {

	//************ TEXT FIELD VALUES ************//	
	//************ TEXT FIELD VALUES ************//	
	//************ TEXT FIELD VALUES ************//	

	
	//************ ITEM OBJECTS ************//	
	public String selectNewItemArticle = "Article";
	public String selectNewItemArticleView = "Article View";
	public String selectNewItemAudioSchedule = "Audio Schedule";
	public String selectNewItemBallpark = "Ballpark";
	public String selectNewItemBallparkMenu = "Ballpark Menu";
	public String selectNewItemBallparkMusic = "Ballpark Music";
	public String selectNewItemBallparkSubmenu = "Ballpark Submenu";
	public String selectNewItemBlogContent = "Blog Content";
	public String selectNewItemBlogContentAlias = "Blog Content Alias";
	public String selectNewItemChron = "Chron";
	public String selectNewItemClosedCaption = "Closed Caption";
	public String selectNewItemClubPromo = "Club Promo";
	public String selectNewItemContributor = "Contributor";
	public String selectNewItemDailyEmail = "Daily Email";
	public String selectNewItemDeviceAnnouncement = "Device Announcement";
	public String selectNewItemDeviceBanner = "Device Banner";
	public String selectNewItemDevicePage = "Device Page";
	public String selectNewItemDigitalAsset = "Digital Asset";
	public String selectNewItemDrawer = "Drawer";
	public String selectNewItemEvent = "Event";
	public String selectNewItemFeature = "Feature";
	public String selectNewItemFeatures = "Features";
	public String selectNewItemFieldOption = "Field Option";
	public String selectNewItemGamePreview = "Game Preview";
	public String selectNewItemGameWrap = "Game Wrap";
	public String selectNewItemHighlight = "Hightlight";
	public String selectNewItemHomepageTab = "Homepage Tab";
	public String selectNewItemHPConfig = "HP Config";
	public String selectNewItemIncludeHTML = "Include - HTML";
	public String selectNewItemInstagramPhoto = "Instagram Photo";
	public String selectNewItemSocialMediaStream = "Social Media Stream";
	public String selectNewItemKiosk = "Kiosk";
	public String selectNewItemLineup = "Lineup";
	public String selectNewItemLineupPlayer = "Lineup Player";
	public String selectNewItemLink = "Link";
	public String selectNewItemList = "List";
	public String selectNewItemMediawall = "Mediawall";
	public String selectNewItemMediawallOverlay = "Mediawall Overlay";
	public String selectNewItemMediawallPanel = "Mediawall Panel";
	public String selectNewItemMLBTVAdModule = "MLBTV Ad Module";
	public String selectNewItemMoundBall = "Mound Ball";
	public String selectNewItemMusicLink = "Music Link";
	public String selectNewItemNote = "Note";
	public String selectNewItemNotebook = "Notebook";
	public String selectNewItemPage = "Page";
	public String selectNewItemPhotoGallery = "Photo Gallery";
	public String selectNewItemPhotoGalleryAlias = "Photo Gallery Alias";
	public String selectNewItemPhotoGalleryList = "Photo Gallery List";
	public String selectNewItemPlayerProspect = "Player Prospect";
	public String selectNewItemPodcastDetail = "Podcast Detail Page";
	public String selectNewItemPodcastEpisode = "Podcast Episode";
	public String selectNewItemPressRelease = "Press Release";
	public String selectNewItemPressboxAsset = "Pressbox Asset";
	public String selectNewItemPressboxAssetList = "Pressbox Asset List";
	public String selectNewItemPreviewAlias = "Preview Alias";
	public String selectNewItemProgramShow = "Program Show";
	public String selectNewItemPromoApplication = "Promo Application";
	public String selectNewItemQuoteSheet = "Quote Sheet";
	public String selectNewItemRaffle = "Raffle";
	public String selectNewItemSchedule = "Schedule";
	public String selectNewItemScrapbook = "Scrapbook";
	public String selectNewItemScrapbookPage = "Scrapbook Page";
	public String selectNewItemSection = "Section";
	public String selectNewItemSeriesConfiguration = "Series Configuration";
	public String selectNewItemShortContent= "Short Content";
	public String selectNewItemTicketPage = "Ticket Page";
	public String selectNewItemTrendingModule = "Trending Module";
	public String selectNewItemTweet = "Tweet";
	public String selectNewItemVideoTopicPage = "Video Topic Page";
	public String selectNewItemTwitterHandle = "Twitter Handle";
	public String selectNewItemVideoClipList = "Video Clip List";
	public String selectNewItemHTMLPage = "HTML Page";
	//************ ITEM OBJECTS ************//	

	//************ LOGIN OBJECTS ************//	
	public static String mainURL = "https://qahomebase.mlbcontrol.net/";
	public static String mainURL2 = "https://qahomebase.mlbcontrol.net/";
	public static String loginUser = "editorhb";
	public static String loginPassword = "B@tter1Up!";
	//************ LOGIN OBJECTS ************//	

	//************ BETA/PROD OBJECTS ************//	
	public static String valueBeta = "beta";
	public static String valueProd = "prod";
	//************ BETA/PROD OBJECTS ************//	

	//************ MINOR LEAGUE OBJECTS ************//	
	public static String minorLeagueSiteSelection = "milb";
	public static String valueMinorTagToolPlayer = "Jones";
	//************ MINOR LEAGUE OBJECTS ************//	

	//************ MAJOR LEAGUE OBJECTS ************//	
	public static String majorLeagueSiteSelection = "mlb";
	public static String valueMajorTagToolPlayer = "Smith";
	//************ MAJOR LEAGUE OBJECTS ************//	

	//************ SEARCH OBJECTS ************//	
	public static String valueBasicSearch = "sd:2014-01-01|ed:2014-04-15|kw:baseball|";
	//************ SEARCH OBJECTS ************//	

	//************ ARTICLE OBJECTS ************//	
	public static String valueArticleInternalName = "Internal Name";
	public static String valueArticleHeadline = "Headline";
	public static String valueArticleSubhead = "Subhead";
	public static String valueArticleAltHeadline = "Alt Headline";
	public static String valueArticleByline = "Byline";
	public static String valueArticleSeoHeadline = "SEO Headline";
	public static String valueArticlePoll = "Poll";
	public static String valueArticleBlurb = "Blurb";
	public static String valueArticleNotes = "Notes";
	public static String valueArticleTagline = "Tagline";
	//************ ARTICLE OBJECTS ************//	
	
	//************ ARTICLE-VIEW OBJECTS ************//	
	public static String valueArticleViewInternalName = "Internal Name";
	public static String valueArticleViewName = "Name";
	public static String valueArticleViewViewKey = "View Key";
	//************ ARTICLE-VIEW OBJECTS ************//	

	//************ AUDIO SCHEDULE OBJECTS ************//	
	public static String valueAudioScheduleInternalName = "Internal Name";
	//************ AUDIO SCHEDULE OBJECTS ************//	

	//************ BALLPARK OBJECTS ************//	
	public static String valueBallparkInternalName = "Internal Name";
	public static String valueBallparkID = "ID";
	public static String valueBallparkName = "Name";
	public static String valueBallparkAddress1 = "123 Address1";
	public static String valueBallparkAddress2 = "Apt Address2";
	public static String valueBallparkLocation = "Location";
	public static String valueBallparkMapType = "Map Type";
	public static String valueBallparkMapVersion = "Map Version 1.0";
	public static String valueBallparkFacebookID = "Facebook ID";
	public static String valueBallparkFoursquareID = "Foursquare ID";
	public static String valueBallparkWebsiteURL = "http://www.WebsiteURL.com";
	public static String valueBallparkThumbnailURL = "http://www.ThumbnailURL.com";
	public static String valueBallparkThumbnailCaption = "Thumbnail Caption";
	public static String valueBallparkTwitterHashTags = "#Twitter #Hash #Tags";
	public static String valueBallparkAboutURL = "http://www.AboutURL.com";
	public static String valueBallparkScheduleURL = "http://www.ScheduleURL.com";
	public static String valueBallparkSmallThumbnailURL = "http://www.SmallThumbnailURL.com";
	public static String valueBallparkStartYear = "Start Year";
	public static String valueBallparkEndYear = "End Year";
	public static String valueBallparkUpgradeURL = "Upgrade URL";
	public static String valueBallparkAbout = "About";
	public static String valueBallparkEventsText = "Events Text";
	public static String valueBallparkSponsorImageText = "Sponsor Image Text";
	public static String valueBallparkSponsorImageURL = "http://www.SponsorImageURL.com";
	public static String valueBallparkSponsorImage2Text = "Sponsor Image 2 Text";
	public static String valueBallparkSponsorImage2URL = "http://www.SponsorImage2URL.com";
	public static String valueBallparkTicketsText = "Tickets Text";
	public static String valueBallparkTicketsURL = "http://www.TicketsURL.com";
	public static String valueBallparkTicketsErrorText = "Tickets Error Text";
	//************ BALLPARK OBJECTS ************//	

	//************ BALLPARK MENU OBJECTS ************//	
	public static String valueBallparkMenuInternalName = "Internal Name";
	public static String valueBallparkMenuDisplayName = "Display Name";
	public static String valueBallparkMenuDisplayImageURL = "http://www.DisplayImageURL.com";
	public static String valueBallparkMenuLinkURL = "http:/www.LinkURL.com";
	public static String valueBallparkMenuLinkName = "Menu Link Name";
	public static String valueBallparkMenuBundleKey = "Bundle Key";
	public static String valueBallparkMenuBundleName = "Bundle Name";
	public static String valueBallparkMenuBundleURL = "http://www.BundleURL.com";
	public static String valueBallparkMenuSharingURL = "http://www.SharingURL.com";
	public static String valueBallparkMenuSharingText = "Sharing Text";
	public static String valueBallparkMenuErrorText = "Error Text";
	public static String valueBallparkMenuSourceURL = "http://www.SourceURL.com";
	//************ BALLPARK MENU OBJECTS ************//	

	//************ BALLPARK MUSIC OBJECTS ************//	
	public static String valueBallparkMusicInternalName = "Internal Name";
	public static String valueBallparkMusicTitle = "Title";
	public static String valueBallparkMusicArtist = "Artist";
	public static String valueBallparkMusicDescription = "Description";
	public static String valueBallparkMusicThumbnail = "Thumbnail";
	public static String valueBallparkMusicRank = "Rank";
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
	public static String valueBlogContentInternalName = "Internal Name";
	public static String valueBlogContentURL = "http://www.URL.com";
	public static String valueBlogContentURLText = "URL Text";
	public static String valueBlogContentHeadline = "Headline";
	public static String valueBlogContentAltHeadline = "Alt Headline";
	public static String valueBlogContentSEOHeadline = "SEO Headline";
	public static String valueBlogContentBlurb = "Blurb";
	public static String valueBlogContentByline = "Byline";
	public static String valueBlogContentCaption = "Caption";
	public static String valueBlogContentMediaCredit = "Media Credit";
	public static String valueBlogContentBody = "Body";
	public static String valueBlogContentSummary = "Summary";
	//************ BLOG CONTENT OBJECTS ************//	

	//************ BLOG CONTENT OBJECTS ALIAS ************//	
	public static String valueBlogContentAliasInternalName = "Internal Name";
	public static String valueBlogContentAliasHeadline = "Headline";
	public static String valueBlogContentAliasBlurb = "Blurb";
	public static String valueBlogContentAliasSummary = "Summary";
	//************ BLOG CONTENT OBJECTS ALIAS ************//	

	//************ CHRON OBJECTS ************//	
	public static String valueChronInternalName = "Internal Name";
	public static String valueChronDateNotation = "Date Notation";
	public static String valueChronYear = "Year";
	public static String valueChronDisplayYear = "Display Year";
	public static String valueChronTitle = "Title";
	public static String valueChronCMSDescription = "CMS Description";
	//************ CHRON OBJECTS ************//	

	//************ CLOSED CAPTION OBJECTS ************//	
	public static String valueClosedCaptionInternalName = "Internal Name";
	//************ CLOSED CAPTION OBJECTS ************//	

	//************ CLUB PROMO OBJECTS ************//	
	public static String valueClubPromoInternalName = "Internal Name";
	public static String valueClubPromoURLExtension = "URL Extension";
	public static String valueClubPromoEventTitle = "Event Title";
	public static String valueClubPromoEventSubtitle = "Event Subtitle";
	public static String valueClubPromoPromoText = "Promo Text";
	public static String valueClubPromoMobileTicketsText = "Mobile Tickets Text";
	public static String valueClubPromoMobileTicketsURL = "http://www.MobileTicketsURL.com";
	public static String valueClubPromoTicketsURL = "http://www.TicketsURL.com";
	public static String valueClubPromoTextCampaignPromo = "Text Campaign Promo";
	public static String valueClubPromoSocialKeyword = "Social Keyword";
	public static String valueClubPromoHighlightsTitle = "Highlights Title";
	public static String valueClubPromoLocationAddress = "Location Address";
	public static String valueClubPromoEventMapTitle = "Event Map Title";
	public static String valueClubPromoScheduleTitle = "Schedule Title";
	public static String valueClubPromoFAQTitle = "FAQ Title";
	//************ CLUB PROMO OBJECTS ************//	

	//************ CONTRIBUTOR OBJECTS ************//	
	public static String valueContributorInternalName = "Internal Name";
	public static String valueContributorFirstName = "First Name";
	public static String valueContributorLastName = "Last Name";
	public static String valueContributorTitle = "Title";
	public static String valueContributorEmail = "Email@mlb.com";
	public static String valueContributorTwitterHandle = "@TwitterHandle";
	public static String valueContributorBlog = "Blog";
	public static String valueContributorBlogTitle = "Blog Title";
	public static String valueContributorRSSFeed = "RSS Feed";
	public static String valueContributorFacebookID = "Facebook ID";
	public static String valueContributorActiveTab = "Active Tab";
	public static String valueContributorHideArticles = "Hide Articles";
	public static String valueContributorVideoKeywordType = "Video Keyword Type";
	public static String valueContributorVideoKeywordValue = "Video Keyword Value";
	public static String valueContributorVideoLandingPage = "Video Landing Page";
	public static String valueContributorBlurb = "Blurb";
	//************ CONTRIBUTOR OBJECTS ************//	

	//************ DAILY EMAIL  OBJECTS ************//	
	public static String valueDailyEmailInternalName = "Internal Name";
	public static String valueDailyEmailSubject = "Subject";
	public static String valueDailyEmailSubjectB = "Subject B";
	public static String valueDailyEmailTriviaQuestion = "Trivia Question";
	public static String valueDailyEmailTriviaAnswer = "Trivia Answer";
	//************ DAILY EMAIL  OBJECTS ************//	
	
	//************ DEVICE ANNOUNCEMENT OBJECTS ************//	
	public static String valueDeviceAnnouncementInternalName = "Internal Name";
	public static String valueDeviceAnnouncementAppVersion = "App Version";
	public static String valueDeviceAnnouncementOSVersion = "OS Version";
	public static String valueDeviceAnnouncementEntitlement = "Entitlement";
	public static String valueDeviceAnnouncementScreen = "Screen";
	public static String valueDeviceAnnouncementType = "Type";
	public static String valueDeviceAnnouncementDisplayType = "Display Type";
	public static String valueDeviceAnnouncementTitle = "Title";
	public static String valueDeviceAnnouncementMessage = "Message";
	public static String valueDeviceAnnouncementOpenLabel = "Open Label";
	public static String valueDeviceAnnouncementOpenLink = "Open Link";
	public static String valueDeviceAnnouncementCloseLabel = "Close Label";
	public static String valueDeviceAnnouncementCloseLink = "Close Link";
	//************ DEVICE ANNOUNCEMENT OBJECTS ************//	

	//************ DEVICE BANNER OBJECTS ************//	
	public static String valueDeviceBannerInternalName = "Internal Name";
	public static String valueDeviceBannerAppVersion = "App Version";
	public static String valueDeviceBannerOSVersion = "OS Version";
	public static String valueDeviceBannerEntitlement = "Entitlement";
	public static String valueDeviceBannerAccessFeature = "Access Feature";
	public static String valueDeviceBannerScreen = "Screen";
	public static String valueDeviceBannerViewID = "View ID";
	public static String valueDeviceBannerType = "Type";
	public static String valueDeviceBannerWebViewType = "Web View Type";
	public static String valueDeviceBannerTitle = "Title";
	public static String valueDeviceBannerLink = "Link";
	public static String valueDeviceBannerBackgroundColor = "Background Color";
	public static String valueDeviceBannerTrackingString = "Tracking String";
	public static String valueDeviceBannerAdMarvelID = "Ad Marvel ID";
	public static String valueDeviceBannerAdMarvelWidth = "Ad Marvel Width";
	public static String valueDeviceBannerAdMarvelHeight = "Ad Marvel Height";
	public static String valueDeviceBannerAdMarvelSectionID = "Ad Marvel Section ID";
	public static String valueDeviceBannerAdMarvelMLBTarget = "Ad Marvel MLB Target";
	public static String valueDeviceBannerAdMarvelExpiryTime = "Ad Marvel Expiry Time";
	public static String valueDeviceBannerMLBTVContentID = "MLB.tv Content ID";
	public static String valueDeviceBannerMLBTVCalendarEventID = "MLB.tv Calendar Event ID";
	public static String valueDeviceBannerSponsor = "Sponsor";
	//************ DEVICE BANNER OBJECTS ************//		
	
	//************ DEVICE PAGE OBJECTS ************//	
	public static String valueDevicePageInternalName = "Internal Name";
	public static String valueDevicePageHeadline = "Headline";
	public static String valueDevicePageBlurb = "Blurb";
	public static String valueDevicePageYearlyPurchaseFlow = "Yearly Purchase Flow";
	public static String valueDevicePageMonthlyPurchaseFlow = "Monthly Purchase Flow";
	public static String valueDevicePageUpgradeLink = "http://www.UpgradeLink.com";
	public static String valueDevicePageActivationLink = "http://www.ActivationLink.com";
	//************ DEVICE PAGE OBJECTS ************//	

	//************ DIGITAL ASSET OBJECTS ************//	
	public static String valueDigitalAssetInternalName = "Internal Name";
	public static String valueDigitalAssetHeadline = "Headline";
	//************ DIGITAL ASSET OBJECTS ************//	
	
	//************ DRAWER OBJECTS ************//	
	public static String valueDrawerInternalName = "Internal Name";
	public static String valueDrawerKicker = "Kicker";
	public static String valueDrawerCustomContent = "Custom Content";
	public static String valueDrawerBlurb = "Blurb";
	public static String valueDrawerURL = "http://www.URL.com";
	public static String valueDrawerURLText = "URL Text";
	public static String valueDrawerNumberOfItems = "2";
	//************ DRAWER OBJECTS ************//	

	//************ EVENT OBJECTS ************//	
	public static String valueEventInternalName = "Internal Name";
	public static String valueEventProgramID = "Program ID";
	public static String valueEventProgram = "Program";
	public static String valueEventLocation = "Location";
	public static String valueEventEventTitle = "Event Title";
	public static String valueEventDescription = "Event Description";
	public static String valueEventURL = "http://www.EventURL.com";
	//************ EVENT OBJECTS ************//	
	
	//************ FEATURE OBJECTS ************//	
	public static String valueFeatureInternalName = "Internal Name";
	public static String valueFeatureHeadline = "Headline";
	public static String valueFeatureURL = "http://www.URL.com";
	public static String valueFeatureURLText = "URL Text";
	public static String valueFeatureMobileURL = "http://www.MobileURL.com";
	public static String valueFeatureBlurb = "Blurb";
	//************ FEATURE OBJECTS ************//	

	//************ FEATURES OBJECTS ************//	
	public static String valueFeaturesInternalName = "Internal Name";
	public static String valueFeaturesNumberOfItems = "2";
	//************ FEATURES OBJECTS ************//	

	//************ FIELD OPTION OBJECTS ************//	
	public static String valueFieldOptionInternalName = "Internal Name";
	public static String valueFieldOptionDisplayName = "Display Name";
	public static String valueFieldOptionValue = "Value";
	//************ FIELD OPTION OBJECTS ************//	
	
	//************ GAME PREVIEW OBJECTS ************//	
	public static String valueGamePreviewInternalName = "Internal Name";
	public static String valueGamePreviewHeadline = "Headline";
	public static String valueGamePreviewHomeHeadline = "Home Headline";
	public static String valueGamePreviewAwayHeadline = "Away Headline";
	public static String valueGamePreviewSubhead = "Subhead";
	public static String valueGamePreviewAltHeadline = "Alt Headline";
	public static String valueGamePreviewByline = "Byline";
	public static String valueGamePreviewBlurb = "Blurb";
	//************ GAME PREVIEW OBJECTS ************//	

	//************ GAME WRAP OBJECTS ************//	
	public static String valueGameWrapInternalName = "Internal Name";
	public static String valueGameWrapHeadline = "Headline";
	public static String valueGameWrapBlurb = "Blurb";

	//************ GAME WRAP OBJECTS ************//	

	//************ HIGHLIGHT OBJECTS ************//	
	public static String valueHighlightInternalName = "Internal Name";
	public static String valueHighlightYear = "1982";
	//************ HIGHLIGHT OBJECTS ************//	
	
	//************ HOMEPAGE TAB OBJECTS ************//	
	public static String valueHomepageTabInternalName = "Internal Name";
	public static String valueHomepageTabDefaultAltText = "Default Alt Text";
	public static String valueHomepageTabDefaultClickthroughURL = "http://www.DefaultClickthroughURL.com"; 
	//************ HOMEPAGE TAB OBJECTS ************//	

	//************ HP CONFIG OBJECTS ************//	
	public static String valueHPConfigInternalName = "Internal Name";
	public static String valueHPConfigBreakingNews = "Breaking News";
	public static String valueHPConfigBreakingNewsURL = "http://www.BreakingNewsURL.com";
	public static String valueHPConfigABTests = "AB Tests";
	public static String valueHPConfigHeaderURL = "http://www.HeaderURL.com";
	public static String valueHPConfigHeaderAlt = "Header Alt";
	//************ HP CONFIG OBJECTS ************//	
 	
	//************ HTML PAGE OBJECTS ************//	
	public static String valueHTMLPageInternalName = "Internal Name";
	public static String valueHTMLPageHeadline = "Headline";
	public static String valueHTMLPageBlurb = "Blurb";
	//************ HTML PAGE OBJECTS ************//	

	//************ HTML INCLUDE OBJECTS ************//	
	public static String valueHTMLIncludeInternalName = "Internal Name";
	//************ HTML INCLUDE OBJECTS ************//	

	//************ INSTAGRAM PHOTO OBJECTS ************//	
	public static String valueInstagramPhotoInternalName = "Internal Name";
	public static String valueInstagramPhotoApprover = "Photo Approver";
	public static String valueInstagramPhotoApprovedTime = "Approved Time";
	public static String valueInstagramPhotoInstagramID = "Instagram ID";
	public static String valueInstagramPhotoImageURL = "http://www.ImageURL.com";
	public static String valueInstagramPhotoLargeImageURL = "http://www.LargeImageURL.com";
	public static String valueInstagramPhotoCaption = "Caption";
	public static String valueInstagramPhotoCreatorID = "Creator ID";
	public static String valueInstagramPhotoCreatorName = "Creator Name";
	public static String valueInstagramPhotoCreatorProfilePicture = "http://www.CreatorProfilePicture.com";
	public static String valueInstagramPhotoCreatedTime = "Created Time";
	public static String valueInstagramPhotoLatitude = "Latitude";
	public static String valueInstagramPhotoLongitude = "Longitude";
	//************ INSTAGRAM PHOTO OBJECTS ************//	
	
	//************ KIOSK OBJECTS ************//	
	public static String valueKioskInternalName = "Internal Name";
	public static String valueKioskCalendarEventID = "Calendar Event ID";
	public static String valueKioskContentID = "ContentID";
	//************ KIOSK OBJECTS ************//	
	
	//************ LINEUP OBJECTS ************//	
	public static String valueLineupInternalName = "Internal Name";
	public static String valueLineupUmpireHP = "1";
	public static String valueLineupUmpire1st = "2";
	public static String valueLineupUmpire2nd = "3";
	public static String valueLineupUmpire3rd = "4";
	public static String valueLineupUmpireLF = "5";
	public static String valueLineupUmpireRF = "6";
	public static String valueLineupUmpireOS = "7";
	public static String valueLineupNotes = "Notes";
	//************ LINEUP OBJECTS ************//	
 
	//************ LINEUP PLAYER OBJECTS ************//	
	public static String valueLineupPlayerInternalName = "Internal Name";
	public static String valueLineupPlayerPosition = "Player Position";
	//************ LINEUP PLAYER OBJECTS ************//	

	//************ LINK OBJECTS ************//	
	public static String valueLinkInternalName = "Internal Name";
	public static String valueLinkLinkText = "Link Test";
	public static String valueLinkLinkURL = "http://www.milb.com";
	public static String valueLinkWidth = "320";
	public static String valueLinkHeight = "240";
	//************ LINK OBJECTS ************//	
	
	//************ LINK OBJECTS ************//	
	public static String valueListInternalName = "Internal Name";
	public static String valueListKey = "Key";
	public static String valueListNumberOfItems = "3";
	public static String valueListBlurb = "Blurb";
	//************ LINK OBJECTS ************//	

	//************ MEDIAWALL OBJECTS ************//	
	public static String valueMediawallInternalName = "Internal Name";
	public static String valueMediawallNumberOfPanels = "3";
	//************ MEDIAWALL OBJECTS ************//	

	//************ MEDIAWALL OVERLAY OBJECTS ************//	
	public static String valueMediawallOverlayInternalName = "Internal Name";
	//************ MEDIAWALL OVERLAY OBJECTS ************//	

	//************ MEDIAWALL PANEL OBJECTS ************//	
	public static String valueMediawallPanelInternalName = "Internal Name";
	public static String valueMediawallPanelHeadline = "Headline";
	public static String valueMediawallPanelURLText = "URL Text";
	public static String valueMediawallPanelURL = "http://www.milb.com";
	public static String valueMediawallPanelMobileURL = "http://m.mlb.com";
	public static String valueMediawallPanelSponsorURL = "http://www.mlb.com";
	public static String valueMediawallPanelBlurb = "Blurb";
	public static String valueMediawallPanelNotes = "Notes";
	public static String valueMediawallPanelDisplayTimeInSeconds = "30";
	public static String valueMediawallPanelVideoAlias = "Baseball.mov";
	//************ MEDIAWALL PANEL OBJECTS ************//	

	//************ MLBTV AD MODULE OBJECTS ************//	
	public static String valueMLBTVAdModuleInternalName = "Internal Name";
	public static String valueMLBTVAdModuleURL = "http://www.URL.com";
	public static String valueMLBTVAdModuleMobileURL = "http://m.URL.com";
	public static String valueMLBTVAdModuleTabletURL = "http://m.tabletURL.com";	
	//************ MLBTV AD MODULE OBJECTS ************//	

	//************ MOUNDBALL OBJECTS ************//	
	public static String valueMoundBallInternalName = "Internal Name";
	public static String valueMoundBallBlurb = "Blurb";
	//************ MOUNDBALL OBJECTS ************//	

	//************ MUSIC LINK OBJECTS ************//	
	public static String valueMusicLinkInternalName = "Internal Name";
	public static String valueMusicLinkUniqueID = "Unique ID";
	public static String valueMusicLinkPreviewURL = "http://www.PreviewURL.com";
	public static String valueMusicLinkMediaURL = "http://www.MediaURL.com";
	//************ MUSIC LINK OBJECTS ************//	
	
	//************ NOTEBOOK OBJECTS ************//	
	public static String valueNotebookInternalName = "Internal Name";
	public static String valueNotebookHeadline = "Headline";
	public static String valueNotebookByline = "Byline";
	public static String valueNotebookSource = "Source";
	public static String valueNotebookTagline = "Tagline";
	//************ NOTEBOOK OBJECTS ************//	

	//************ PHOTO GALLERY OBJECTS ************//	
	
	public static String valuePhotoGalleryInternalName = "Internal Name";
	public static String valuePhotoGalleryTitle = "Title";
	public static String valuePhotoGallerySpanishTitle = "El Title En Espanol";
	public static String valuePhotoGalleryBlurb = "Blurb";
	public static String valuePhotoGallerySpanishBlurb = "El Blurb En Espanol";
	//************ PHOTO GALLERY OBJECTS ************//	

	//************ PRESS RELEASE OBJECTS ************//	
	public static String valuePressReleaseInternalName = "Internal Name";
	public static String valuePressReleaseNotes = "Notes";
	public static String valuePressReleaseDisplayHeadline = "Display Headline";
	public static String valuePressReleaseHeadline = "Press Release Headline";
	public static String valuePressReleaseSubHeadline = "Sub Headline";
	public static String valuePressReleaseBlurb = "Blurb";
	//************ PRESS RELEASE OBJECTS ************//	

	//************ SECTION OBJECTS ************//	
	public static String valueSectionInternalName = "Internal Name";
	public static String valueSectionSectionID = "1";
	public static String valueSectionShortTitle = "Short Title";
	public static String valueSectionLongTitle = "Long Title";
	public static String valueSectionWiredURL = "http://www.WiredURL.com";
	public static String valueSectionMobileURL = "http://www.MobileURL.com";
	public static String valueSectionTarget = "http://www.WiredURL.com";
	public static String valueSectionType = "http://www.WiredURL.com";
	//************ SECTION OBJECTS ************//	

	//************ SOCIAL MEDIA STREAM OBJECTS ************//	
	public static String valueSocialMediaStreamInternalName = "Internal Name";
	public static String valueSocialMediaStreamDisplayName = "Display Name";
	public static String valueSocialMediaStreamKey = "Key";
	//************ SOCIAL MEDIA STREAM OBJECTS ************//	

	//************ VIDEO TOPIC PAGE OBJECTS ************//	
	public static String valueVideoTopicPageInternalName = "Internal Name";
	public static String valueVideoTopicPageHeadline = "Headline";
	public static String valueVideoTopicPageFacebookDescription = "Facebook Description";
	public static String valueVideoTopicPageMaxItems = "3";
	public static String valueVideoTopicPageItemsPerPage = "3";
	public static String valueVideoTopicPageSearchCriteria = "Page Search Criteria";
	public static String valueVideoTopicPageRelatedLink = "Link";
	public static String valueVideoTopicPageCustomTemplatePath = "Custom Template Path";
	public static String valueVideoTopicPageJavascriptPath = "Javascript Path";
	public static String valueVideoTopicPageStylesheetPath = "Stylesheet Path";
	public static String valueVideoTopicPageCustomPanel = "Custom Panel";
	public static String valueVideoTopicPageTwitterHandle = "Twitter Handle";
	public static String valueVideoTopicPagePollKey = "Poll Key";
	//************ VIDEO TOPIC PAGE OBJECTS ************//	

	//************ VIDEO TOPIC PAGE OBJECTS ************//	
	public static String valueVideoClipListInternalName = "Internal Name";
	public static String valueVideoClipListHeadline = "Headline";
	public static String valueVideoClipListListDefaultView = "123";	
	//************ VIDEO TOPIC PAGE OBJECTS ************//	

	//************ TEAM CONTENT PROBABLES OBJECTS ************//	
	public static String valueProbablesTeamContentDateChangerMonth = "July";
	public static String valueProbablesTeamContentDateChangerDate = "1";
	public static String valueProbablesTeamContentDateChangerYear = "2014";	
	//************ TEAM CONTENT PROBABLES OBJECTS ************//	
	
	//************ GAME CONTENT PROBABLES OBJECTS ************//	
	public static String valueProbablesGameContentDateChangerMonth = "July";
	public static String valueProbablesGameContentDateChangerDate = "1";
	public static String valueProbablesGameContentDateChangerYear = "2014";	
	//************ GAME CONTENT PROBABLES OBJECTS ************//	
	
	//************ TEXT FIELD VALUES ************//	
	//************ TEXT FIELD VALUES ************//	
	//************ TEXT FIELD VALUES ************//	

	//************ MAJOR LEAGUE TESTS ************//
	//************ MAJOR LEAGUE TESTS ************//
	//************ MAJOR LEAGUE TESTS ************//


	@Test
	public void homeBaseTestMLB000TestFunction() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(getDriver());
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.probablesGameContentAddPlayers(mainURL, valueProbablesGameContentDateChangerMonth, valueProbablesGameContentDateChangerDate, valueProbablesGameContentDateChangerYear);
		homePage.probablesGameContentDeletePlayers(mainURL, valueProbablesGameContentDateChangerMonth, valueProbablesGameContentDateChangerDate, valueProbablesGameContentDateChangerYear);
		return;
	}	
	
	@Test
	public void homeBaseTestMLB001Login() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException 
	{
		HB_HomePage homePage = new HB_HomePage(getDriver());
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		return;
	}	

	@Test
	public void homeBaseTestMLB002BasicSearch() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(getDriver());
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.basicSearch(valueBasicSearch);
		return;
	}	

	@Test
	public void homeBaseTestMLB003CreateSaveBetaNewArticle() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(getDriver());
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem(selectNewItemArticle);
		homePage.fillAndSaveNewArticle(mainURL,valueBeta,valueArticleInternalName,valueArticleHeadline,valueArticleSubhead,valueArticleAltHeadline,valueArticleByline,valueArticleSeoHeadline,valueArticlePoll,valueMajorTagToolPlayer,valueArticleBlurb, valueArticleNotes,valueArticleTagline);
		return;
	}	

	@Test
	public void homeBaseTestMLB004CreateSaveBetaNewArticleView() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(getDriver());
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem(selectNewItemArticleView);
		homePage.fillAndSaveNewArticleView(mainURL,valueBeta, valueArticleViewInternalName,valueArticleViewName,valueArticleViewViewKey, valueMajorTagToolPlayer);
		return;
	}	

	@Test
	public void homeBaseTestMLB005CreateSaveBetaNewAudioSchedule() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(getDriver());
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem(selectNewItemAudioSchedule);
		homePage.fillAndSaveNewAudioSchedule(mainURL,valueBeta, valueAudioScheduleInternalName,valueMajorTagToolPlayer);
		return;
	}	

	@Test
	public void homeBaseTestMLB006CreateSaveBetaNewBallpark() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(getDriver());
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem(selectNewItemBallpark);
		homePage.fillAndSaveNewBallpark(mainURL,valueBeta, valueBallparkInternalName, valueBallparkID, valueBallparkName, valueBallparkAddress1, valueBallparkAddress2, valueBallparkLocation, valueBallparkMapType, valueBallparkMapVersion, valueBallparkFacebookID, valueBallparkFoursquareID, valueBallparkWebsiteURL, valueBallparkThumbnailURL, valueBallparkThumbnailCaption, valueBallparkTwitterHashTags, valueBallparkAboutURL, valueBallparkScheduleURL, valueBallparkSmallThumbnailURL, valueBallparkStartYear, valueBallparkEndYear, valueBallparkUpgradeURL, valueBallparkAbout, valueBallparkEventsText, valueBallparkSponsorImageText, valueBallparkSponsorImageURL, valueBallparkSponsorImage2Text, valueBallparkSponsorImage2URL, valueBallparkTicketsText, valueBallparkTicketsURL, valueBallparkTicketsErrorText, valueMajorTagToolPlayer);
 		return;
	}	

	@Test
	public void homeBaseTestMLB007CreateSaveBetaNewBallparkMenu() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(getDriver());
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem(selectNewItemBallparkMenu);
		homePage.fillAndSaveNewBallparkMenu(mainURL,valueBeta, valueBallparkMenuInternalName, valueBallparkMenuDisplayName, valueBallparkMenuDisplayImageURL, valueBallparkMenuLinkURL, valueBallparkMenuLinkName, valueBallparkMenuBundleKey, valueBallparkMenuBundleName, valueBallparkMenuBundleURL, valueBallparkMenuSharingURL, valueBallparkMenuSharingText, valueBallparkMenuErrorText, valueBallparkMenuSourceURL, valueMajorTagToolPlayer);
		return;
	}	

	@Test
	public void homeBaseTestMLB008CreateSaveBetaNewBallparkMusic() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(getDriver());
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem(selectNewItemBallparkMusic);
		homePage.fillAndSaveNewBallparkMusic(mainURL,valueBeta, valueBallparkMusicInternalName, valueBallparkMusicTitle, valueBallparkMusicArtist, valueBallparkMusicDescription, valueBallparkMusicThumbnail, valueBallparkMusicRank, valueMajorTagToolPlayer);
		return;
	}	

	@Test
	public void homeBaseTestMLB009CreateSaveBetaNewBallparkSubmenu() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(getDriver());
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem(selectNewItemBallparkSubmenu);
		homePage.fillAndSaveNewBallparkSubmenu(mainURL,valueBeta, valueBallparkMenuInternalName, valueBallparkMenuDisplayName, valueBallparkMenuDisplayImageURL, valueBallparkMenuLinkURL, valueBallparkMenuLinkName, valueBallparkMenuBundleKey, valueBallparkMenuBundleName, valueBallparkMenuBundleURL, valueBallparkMenuSharingURL, valueBallparkMenuSharingText, valueBallparkMenuErrorText, valueBallparkMenuSourceURL, valueMajorTagToolPlayer);
		return;
	}	

  	@Test
	public void homeBaseTestMLB010CreateSaveBetaNewBlogContent() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(getDriver());
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem(selectNewItemBlogContent);
		homePage.fillAndSaveNewBlogContent(mainURL,valueBeta, valueBlogContentInternalName, valueBlogContentURL, valueBlogContentURLText, valueBlogContentHeadline, valueBlogContentAltHeadline, valueBlogContentSEOHeadline, valueBlogContentBlurb, valueBlogContentByline, valueBlogContentCaption, valueBlogContentMediaCredit, valueBlogContentBody, valueBlogContentSummary, valueMajorTagToolPlayer);
		return;
	}	

  	@Test
	public void homeBaseTestMLB011CreateSaveBetaNewBlogContentAlias() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(getDriver());
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem(selectNewItemBlogContentAlias);
		homePage.fillAndSaveNewBlogContentAlias(mainURL,valueBeta, valueBlogContentAliasInternalName, valueBlogContentAliasHeadline, valueBlogContentAliasBlurb, valueBlogContentAliasSummary, valueMajorTagToolPlayer);
		return;
	}	

  	@Test
	public void homeBaseTestMLB012CreateSaveBetaNewChron() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(getDriver());
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem(selectNewItemChron);
		homePage.fillAndSaveNewChron(mainURL,valueBeta, valueChronInternalName, valueChronDateNotation, valueChronYear, valueChronDisplayYear, valueChronTitle, valueChronCMSDescription, valueMajorTagToolPlayer);
		return;
	}	

  	@Test
	public void homeBaseTestMLB013CreateSaveBetaNewClosedCaption() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(getDriver());
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem(selectNewItemClosedCaption);
		homePage.fillAndSaveNewClosedCaption(mainURL,valueBeta, valueClosedCaptionInternalName, valueMajorTagToolPlayer);
		return;
	}	

  	@Test
	public void homeBaseTestMLB014CreateSaveBetaNewClubPromo() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(getDriver());
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem(selectNewItemClubPromo);
		homePage.fillAndSaveNewClubPromo(mainURL,valueBeta, valueClubPromoInternalName, valueClubPromoURLExtension, valueClubPromoEventTitle, valueClubPromoEventSubtitle, valueClubPromoPromoText, valueClubPromoMobileTicketsText, valueClubPromoMobileTicketsURL, valueClubPromoTicketsURL, valueClubPromoTextCampaignPromo, valueClubPromoSocialKeyword, valueClubPromoHighlightsTitle, valueClubPromoLocationAddress, valueClubPromoEventMapTitle, valueClubPromoScheduleTitle, valueClubPromoFAQTitle, valueMajorTagToolPlayer);
		return;
	}	

  	@Test
	public void homeBaseTestMLB015CreateSaveBetaNewContributor() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(getDriver());
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem(selectNewItemContributor);
		homePage.fillAndSaveNewContributor(mainURL,valueBeta, valueContributorInternalName, valueContributorFirstName, valueContributorLastName, valueContributorTitle, valueContributorEmail, valueContributorTwitterHandle, valueContributorBlog, valueContributorBlogTitle, valueContributorRSSFeed, valueContributorFacebookID, valueContributorActiveTab, valueContributorHideArticles, valueContributorVideoKeywordType, valueContributorVideoKeywordValue, valueContributorVideoLandingPage, valueContributorBlurb, valueMajorTagToolPlayer);
		return;
	}	

  	@Test
	public void homeBaseTestMLB016CreateSaveBetaNewDailyEmail() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(getDriver());
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem(selectNewItemDailyEmail);
		homePage.fillAndSaveNewDailyEmail(mainURL,valueBeta, valueDailyEmailInternalName, valueDailyEmailSubject, valueDailyEmailSubjectB, valueDailyEmailTriviaQuestion, valueDailyEmailTriviaAnswer, valueMajorTagToolPlayer);
		return;
	}	

  	@Test
	public void homeBaseTestMLB017CreateSaveBetaNewDeviceAnnouncement() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(getDriver());
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem(selectNewItemDeviceAnnouncement);
		homePage.fillAndSaveNewDeviceAnnouncement(mainURL,valueBeta, valueDeviceAnnouncementInternalName, valueDeviceAnnouncementAppVersion, valueDeviceAnnouncementOSVersion, valueDeviceAnnouncementEntitlement, valueDeviceAnnouncementScreen, valueDeviceAnnouncementType, valueDeviceAnnouncementDisplayType, valueDeviceAnnouncementTitle, valueDeviceAnnouncementMessage, valueDeviceAnnouncementOpenLabel, valueDeviceAnnouncementOpenLink, valueDeviceAnnouncementCloseLabel, valueDeviceAnnouncementCloseLink, valueMajorTagToolPlayer);
		return;
	}	

  	@Test
	public void homeBaseTestMLB018CreateSaveBetaNewDeviceBanner() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(getDriver());
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem(selectNewItemDeviceBanner);
		homePage.fillAndSaveNewDeviceBanner(mainURL,valueBeta, valueDeviceBannerInternalName, valueDeviceBannerAppVersion, valueDeviceBannerOSVersion, valueDeviceBannerEntitlement, valueDeviceBannerAccessFeature, valueDeviceBannerScreen, valueDeviceBannerViewID, valueDeviceBannerType, valueDeviceBannerWebViewType, valueDeviceAnnouncementTitle, valueDeviceBannerLink, valueDeviceBannerBackgroundColor, valueDeviceBannerTrackingString, valueDeviceBannerAdMarvelID, valueDeviceBannerAdMarvelWidth, valueDeviceBannerAdMarvelHeight, valueDeviceBannerAdMarvelSectionID, valueDeviceBannerAdMarvelMLBTarget, valueDeviceBannerAdMarvelExpiryTime, valueDeviceBannerMLBTVContentID, valueDeviceBannerMLBTVCalendarEventID, valueDeviceBannerSponsor, valueMajorTagToolPlayer);
		return;
	}	

  	@Test
	public void homeBaseTestMLB019CreateSaveBetaNewDevicePage() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(getDriver());
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem(selectNewItemDevicePage);
		homePage.fillAndSaveNewDevicePage(mainURL,valueBeta, valueDevicePageInternalName, valueDevicePageHeadline, valueDevicePageBlurb, valueDevicePageYearlyPurchaseFlow, valueDevicePageMonthlyPurchaseFlow, valueDevicePageUpgradeLink, valueDevicePageActivationLink, valueMajorTagToolPlayer);
		return;
	}	

//	@Test
	public void homeBaseTestMLB020CreateSaveBetaNewDigitalAsset() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(getDriver());
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem(selectNewItemDigitalAsset);
		homePage.fillAndSaveNewDigitalAsset(mainURL,valueBeta, valueDigitalAssetInternalName,valueDigitalAssetHeadline, valueMajorTagToolPlayer);
		return;
	}	

  	@Test
	public void homeBaseTestMLB021CreateSaveBetaNewDrawer() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(getDriver());
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem(selectNewItemDrawer);
		homePage.fillAndSaveNewDrawer(mainURL,valueBeta, valueDrawerInternalName, valueDrawerKicker, valueDrawerCustomContent, valueDrawerBlurb, valueDrawerURL, valueDrawerURLText, valueDrawerNumberOfItems, valueMajorTagToolPlayer);
		return;
	}	

  	@Test
	public void homeBaseTestMLB022CreateSaveBetaNewEvent() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(getDriver());
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem(selectNewItemEvent);
		homePage.fillAndSaveNewEvent(mainURL,valueBeta, valueEventInternalName, valueEventProgramID, valueEventProgram, valueEventLocation, valueEventEventTitle, valueEventDescription, valueEventURL, valueMajorTagToolPlayer);
		return;
	}	

  	@Test
	public void homeBaseTestMLB023CreateSaveBetaNewFeature() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(getDriver());
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem(selectNewItemFeature);
		homePage.fillAndSaveNewFeature(mainURL,valueBeta, valueFeatureInternalName, valueFeatureHeadline, valueFeatureURL, valueFeatureURLText, valueFeatureMobileURL, valueFeatureBlurb, valueMajorTagToolPlayer);
		return;
	}	

  	@Test
	public void homeBaseTestMLB024CreateSaveBetaNewFeatures() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(getDriver());
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem(selectNewItemFeatures);
		homePage.fillAndSaveNewFeatures(mainURL,valueBeta, valueFeaturesInternalName, valueFeaturesNumberOfItems, valueMajorTagToolPlayer);
		return;
	}	

  	@Test
	public void homeBaseTestMLB025CreateSaveBetaNewFieldOption() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(getDriver());
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem(selectNewItemFieldOption);
		homePage.fillAndSaveNewFieldOption(mainURL,valueBeta, valueFieldOptionInternalName,valueFieldOptionDisplayName,valueFieldOptionValue,valueMajorTagToolPlayer);
		return;
	}	

  	@Test
	public void homeBaseTestMLB026CreateSaveBetaNewGamePreview() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(getDriver());
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem(selectNewItemGamePreview);
		homePage.fillAndSaveNewGamePreview(mainURL,valueBeta, valueGamePreviewInternalName, valueGamePreviewHeadline, valueGamePreviewHomeHeadline, valueGamePreviewAwayHeadline, valueGamePreviewSubhead, valueGamePreviewAltHeadline, valueGamePreviewByline, valueGamePreviewBlurb, valueMajorTagToolPlayer);
		return;
	}	

  	@Test
	public void homeBaseTestMLB027CreateSaveBetaNewGameWrap() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(getDriver());
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem(selectNewItemGameWrap);
		homePage.fillAndSaveNewGameWrap(mainURL,valueBeta, valueGameWrapInternalName, valueGameWrapHeadline, valueGameWrapBlurb, valueMajorTagToolPlayer);
		return;
	}	

  	@Test
	public void homeBaseTestMLB028CreateSaveBetaNewHighlight() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(getDriver());
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem(selectNewItemHighlight);
		homePage.fillAndSaveNewHighlight(mainURL,valueBeta, valueHighlightInternalName,valueHighlightYear,valueMajorTagToolPlayer);
		return;
	}	

  	@Test
	public void homeBaseTestMLB029CreateSaveBetaNewHomepageTab() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(getDriver());
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem(selectNewItemHomepageTab);
		homePage.fillAndSaveNewHomepageTab(mainURL,valueBeta, valueHomepageTabInternalName, valueHomepageTabDefaultAltText, valueHomepageTabDefaultClickthroughURL, valueMajorTagToolPlayer);
		return;
	}	

  	@Test
	public void homeBaseTestMLB030CreateSaveBetaNewHPConfig() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(getDriver());
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem(selectNewItemHPConfig);
		homePage.fillAndSaveNewHPConfig(mainURL,valueBeta, valueHPConfigInternalName, valueHPConfigBreakingNews, valueHPConfigBreakingNewsURL, valueHPConfigABTests, valueHPConfigHeaderURL, valueHPConfigHeaderAlt, valueMajorTagToolPlayer);
		return;
	}	

  	@Test
	public void homeBaseTestMLB031CreateSaveBetaNewHTMLInclude() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(getDriver());
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem(selectNewItemIncludeHTML);
		homePage.fillAndSaveNewHTMLInclude(mainURL,valueBeta, valueHTMLIncludeInternalName, valueMajorTagToolPlayer);
		return;
	}	

  	@Test
	public void homeBaseTestMLB032CreateSaveBetaNewInstagramPhoto() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(getDriver());
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem(selectNewItemInstagramPhoto);
		homePage.fillAndSaveNewInstagramPhoto(mainURL,valueBeta, valueInstagramPhotoInternalName, valueInstagramPhotoApprover, valueInstagramPhotoApprovedTime, valueInstagramPhotoInstagramID, valueInstagramPhotoImageURL, valueInstagramPhotoLargeImageURL, valueInstagramPhotoCaption, valueInstagramPhotoCreatorID, valueInstagramPhotoCreatorName, valueInstagramPhotoCreatorProfilePicture, valueInstagramPhotoCreatedTime, valueInstagramPhotoLatitude, valueInstagramPhotoLongitude, valueMajorTagToolPlayer);
		return;
	}	

  	@Test
	public void homeBaseTestMLB033CreateSaveBetaNewSocialMediaStream() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(getDriver());
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem(selectNewItemSocialMediaStream);
		homePage.fillAndSaveNewSocialMediaStream(mainURL,valueBeta, valueSocialMediaStreamInternalName, valueSocialMediaStreamDisplayName, valueSocialMediaStreamKey, valueMajorTagToolPlayer);
		return;
	}	

  	@Test
	public void homeBaseTestMLB034CreateSaveBetaNewKiosk() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(getDriver());
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem(selectNewItemKiosk);
		homePage.fillAndSaveNewKiosk(mainURL,valueBeta, valueKioskInternalName, valueKioskCalendarEventID, valueKioskContentID, valueMajorTagToolPlayer);
		return;
	}	

  	@Test
	public void homeBaseTestMLB035CreateSaveBetaNewLineup() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(getDriver());
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem(selectNewItemLineup);
		homePage.fillAndSaveNewLineup(mainURL,valueBeta, valueLineupInternalName, valueLineupUmpireHP, valueLineupUmpire1st, valueLineupUmpire2nd, valueLineupUmpire3rd, valueLineupUmpireLF, valueLineupUmpireRF, valueLineupUmpireOS, valueLineupNotes, valueMajorTagToolPlayer);
		return;
	}	

  	@Test
	public void homeBaseTestMLB036CreateSaveBetaNewLineupPlayer() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(getDriver());
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem(selectNewItemLineupPlayer);
		homePage.fillAndSaveNewLineupPlayer(mainURL,valueBeta, valueLineupPlayerInternalName, valueLineupPlayerPosition, valueMajorTagToolPlayer);
		return;
	}	

  	@Test
	public void homeBaseTestMLB037CreateSaveBetaNewLink() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(getDriver());
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem(selectNewItemLink);
		homePage.fillAndSaveNewLink(mainURL,valueBeta, valueLinkInternalName,valueLinkLinkText,valueLinkLinkURL, valueLinkWidth,valueLinkHeight, valueMajorTagToolPlayer);
		return;
	}	

	@Test
	public void homeBaseTestMLB038CreateSaveBetaNewList() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(getDriver());
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem(selectNewItemList);
		homePage.fillAndSaveNewList(mainURL,valueBeta, valueListInternalName, valueListKey, valueListNumberOfItems, valueListBlurb, valueMajorTagToolPlayer);
		return;
	}	

  	@Test
	public void homeBaseTestMLB039CreateSaveBetaNewMediawall() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(getDriver());
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem(selectNewItemMediawall);
		homePage.fillAndSaveNewMediawall(mainURL,valueBeta, valueMediawallInternalName, valueMediawallNumberOfPanels, valueMajorTagToolPlayer);
		return;
	}	

  	@Test
	public void homeBaseTestMLB040CreateSaveBetaNewMediawallOverlay() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(getDriver());
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem(selectNewItemMediawallOverlay);
		homePage.fillAndSaveNewMediawallOverlay(mainURL,valueBeta, valueMediawallOverlayInternalName, valueMajorTagToolPlayer);
		return;
	}	

  	@Test
	public void homeBaseTestMLB041CreateSaveBetaNewMediaWallPanel() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(getDriver());
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem(selectNewItemMediawallPanel);
		homePage.fillAndSaveNewMediaWallPanel(mainURL,valueBeta, valueMediawallPanelInternalName,valueMediawallPanelHeadline,valueMediawallPanelURLText, valueMediawallPanelURL,valueMediawallPanelMobileURL,valueMediawallPanelSponsorURL,valueMediawallPanelBlurb,valueMediawallPanelNotes, valueMediawallPanelDisplayTimeInSeconds, valueMediawallPanelVideoAlias, valueMajorTagToolPlayer);
		return;
	}	

  	@Test
	public void homeBaseTestMLB042CreateSaveBetaNewMLBTVAdModule() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(getDriver());
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem(selectNewItemMLBTVAdModule);
		homePage.fillAndSaveNewMLBTVAdModule(mainURL,valueBeta, valueMLBTVAdModuleInternalName, valueMLBTVAdModuleURL, valueMLBTVAdModuleMobileURL, valueMLBTVAdModuleTabletURL, valueMajorTagToolPlayer);
		return;
	}	

  	@Test
	public void homeBaseTestMLB043CreateSaveBetaNewMoundBall() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(getDriver());
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem(selectNewItemMoundBall);
		homePage.fillAndSaveNewMoundBall(mainURL,valueBeta, valueMoundBallInternalName, valueMoundBallBlurb, valueMajorTagToolPlayer);
		return;
	}	

  	@Test
	public void homeBaseTestMLB044CreateSaveBetaNewMusicLink() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(getDriver());
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem(selectNewItemMusicLink);
		homePage.fillAndSaveNewMusicLink(mainURL,valueBeta, valueMusicLinkInternalName, valueMusicLinkUniqueID, valueMusicLinkPreviewURL, valueMusicLinkMediaURL, valueMajorTagToolPlayer);
		return;
	}	

  	@Test
	public void homeBaseTestMLB045CreateSaveBetaNewNote() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(getDriver());
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem(selectNewItemNote);
		homePage.fillAndSaveNewNote(mainURL,valueBeta, valueAudioScheduleInternalName, valueMajorTagToolPlayer);
		return;
	}	

  	@Test
	public void homeBaseTestMLB046CreateSaveBetaNewNotebook() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(getDriver());
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem(selectNewItemNotebook);
		homePage.fillAndSaveNewNotebook(mainURL,valueBeta, valueNotebookInternalName,valueNotebookHeadline,valueNotebookByline,valueNotebookSource, valueNotebookTagline, valueMajorTagToolPlayer);
		return;
	}	

  	@Test
	public void homeBaseTestMLB047CreateSaveBetaNewPage() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(getDriver());
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem(selectNewItemPage);
		homePage.fillAndSaveNewPage(mainURL,valueBeta, valueAudioScheduleInternalName, valueMajorTagToolPlayer);
		return;
	}	

  	@Test
	public void homeBaseTestMLB048CreateSaveBetaNewPhotoGallery() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(getDriver());
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem(selectNewItemPhotoGallery);
		homePage.fillAndSaveNewPhotoGallery(mainURL,valueBeta, valuePhotoGalleryInternalName,valuePhotoGalleryTitle,valuePhotoGallerySpanishTitle,valuePhotoGalleryBlurb,valuePhotoGallerySpanishBlurb, valueMajorTagToolPlayer);
		return;
	}	
	
  	@Test
	public void homeBaseTestMLB049CreateSaveBetaNewPhotoGalleryAlias() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(getDriver());
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem(selectNewItemPhotoGalleryAlias);
		homePage.fillAndSaveNewPhotoGalleryAlias(mainURL,valueBeta, valueAudioScheduleInternalName, valueMajorTagToolPlayer);
		return;
	}	

  	@Test
	public void homeBaseTestMLB050CreateSaveBetaNewPhotoGalleryList() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(getDriver());
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem(selectNewItemPhotoGalleryList);
		homePage.fillAndSaveNewPhotoGalleryList(mainURL,valueBeta, valueAudioScheduleInternalName, valueMajorTagToolPlayer);
		return;
	}	

  	@Test
	public void homeBaseTestMLB051CreateSaveBetaNewProspect() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(getDriver());
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem(selectNewItemPlayerProspect);
		homePage.fillAndSaveNewProspect(mainURL,valueBeta, valueAudioScheduleInternalName, valueMajorTagToolPlayer);
		return;
	}	

  	@Test
	public void homeBaseTestMLB052CreateSaveBetaNewPodcastDetail() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(getDriver());
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem(selectNewItemPodcastDetail);
		homePage.fillAndSaveNewPodcastDetail(mainURL,valueBeta, valueAudioScheduleInternalName, valueMajorTagToolPlayer);
		return;
	}	

  	@Test
	public void homeBaseTestMLB053CreateSaveBetaNewPodcastEpisode() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(getDriver());
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem(selectNewItemPodcastEpisode);
		homePage.fillAndSaveNewPodcastEpisode(mainURL,valueBeta, valueAudioScheduleInternalName, valueMajorTagToolPlayer);
		return;
	}	

  	@Test
	public void homeBaseTestMLB054CreateSaveBetaNewPressRelease() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(getDriver());
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem(selectNewItemPressRelease);
		homePage.fillAndSaveNewPressRelease(mainURL,valueBeta, valuePressReleaseInternalName, valuePressReleaseNotes, valuePressReleaseDisplayHeadline, valuePressReleaseHeadline, valuePressReleaseSubHeadline, valuePressReleaseBlurb, valueMajorTagToolPlayer);
		return;
	}	

  	@Test
	public void homeBaseTestMLB055CreateSaveBetaNewPressboxAsset() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(getDriver());
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem(selectNewItemPressboxAsset);
		homePage.fillAndSaveNewPressboxAsset(mainURL,valueBeta, valueAudioScheduleInternalName, valueMajorTagToolPlayer);
		return;
	}	

  	@Test
	public void homeBaseTestMLB056CreateSaveBetaNewPressboxAssetList() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(getDriver());
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem(selectNewItemPressboxAssetList);
		homePage.fillAndSaveNewPressboxAssetList(mainURL,valueBeta, valueAudioScheduleInternalName, valueMajorTagToolPlayer);
		return;
	}	

  	@Test
	public void homeBaseTestMLB057CreateSaveBetaNewPreviewAlias() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(getDriver());
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem(selectNewItemPreviewAlias);
		homePage.fillAndSaveNewPreviewAlias(mainURL,valueBeta, valueAudioScheduleInternalName, valueMajorTagToolPlayer);
		return;
	}	

  	@Test
	public void homeBaseTestMLB058CreateSaveBetaNewProgramShow() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(getDriver());
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem(selectNewItemProgramShow);
		homePage.fillAndSaveNewProgramShow(mainURL,valueBeta, valueAudioScheduleInternalName, valueMajorTagToolPlayer);
		return;
	}	

  	@Test
	public void homeBaseTestMLB059CreateSaveBetaNewPromoApplication() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(getDriver());
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem(selectNewItemPromoApplication);
		homePage.fillAndSaveNewPromoApplication(mainURL,valueBeta, valueAudioScheduleInternalName, valueMajorTagToolPlayer);
		return;
	}	

  	@Test
	public void homeBaseTestMLB060CreateSaveBetaNewQuoteSheet() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(getDriver());
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem(selectNewItemQuoteSheet);
		homePage.fillAndSaveNewQuoteSheet(mainURL,valueBeta, valueAudioScheduleInternalName, valueMajorTagToolPlayer);
		return;
	}	

  	@Test
	public void homeBaseTestMLB061CreateSaveBetaNewRaffle() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(getDriver());
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem(selectNewItemRaffle);
		homePage.fillAndSaveNewRaffle(mainURL,valueBeta, valueAudioScheduleInternalName, valueMajorTagToolPlayer);
		return;
	}	

  	@Test
	public void homeBaseTestMLB062CreateSaveBetaNewSchedule() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(getDriver());
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem(selectNewItemSchedule);
		homePage.fillAndSaveNewSchedule(mainURL,valueBeta, valueAudioScheduleInternalName, valueMajorTagToolPlayer);
		return;
	}	

  	@Test
	public void homeBaseTestMLB063CreateSaveBetaNewScrapbook() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(getDriver());
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem(selectNewItemScrapbook);
		homePage.fillAndSaveNewScrapbook(mainURL,valueBeta, valueAudioScheduleInternalName, valueMajorTagToolPlayer);
		return;
	}	

  	@Test
	public void homeBaseTestMLB064CreateSaveBetaNewScrapbookPage() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(getDriver());
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem(selectNewItemScrapbookPage);
		homePage.fillAndSaveNewScrapbookPage(mainURL,valueBeta, valueAudioScheduleInternalName, valueMajorTagToolPlayer);
		return;
	}	

  	@Test
	public void homeBaseTestMLB065CreateSaveBetaNewSection() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(getDriver());
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem(selectNewItemSection);
		homePage.fillAndSaveNewSection(mainURL,valueBeta, valueSectionInternalName, valueSectionSectionID, valueSectionShortTitle, valueSectionLongTitle, valueSectionWiredURL, valueSectionMobileURL, valueSectionTarget, valueSectionType, valueMajorTagToolPlayer);
		return;
	}	

  	@Test
	public void homeBaseTestMLB066CreateSaveBetaNewSeriesConfiguration() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(getDriver());
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem(selectNewItemSeriesConfiguration);
		homePage.fillAndSaveNewSeriesConfiguration(mainURL,valueBeta, valueAudioScheduleInternalName, valueMajorTagToolPlayer);
		return;
	}	

  	@Test
	public void homeBaseTestMLB067CreateSaveBetaNewShortContent() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(getDriver());
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem(selectNewItemShortContent);
		homePage.fillAndSaveNewShortContent(mainURL,valueBeta, valueAudioScheduleInternalName, valueMajorTagToolPlayer);
		return;
	}	

  	@Test
	public void homeBaseTestMLB068CreateSaveBetaNewTicketPage() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(getDriver());
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem(selectNewItemTicketPage);
		homePage.fillAndSaveNewTicketPage(mainURL,valueBeta, valueAudioScheduleInternalName, valueMajorTagToolPlayer);
		return;
	}	

  	@Test
	public void homeBaseTestMLB069CreateSaveBetaNewTrendingModule() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(getDriver());
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem(selectNewItemTrendingModule);
		homePage.fillAndSaveNewTrendingModule(mainURL,valueBeta, valueAudioScheduleInternalName, valueMajorTagToolPlayer);
		return;
	}	

  	@Test
	public void homeBaseTestMLB070CreateSaveBetaNewTweet() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(getDriver());
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem(selectNewItemTweet);
		homePage.fillAndSaveNewTweet(mainURL,valueBeta, valueAudioScheduleInternalName, valueMajorTagToolPlayer);
		return;
	}	

  	@Test
	public void homeBaseTestMLB071CreateSaveBetaNewVideoTopicPage() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(getDriver());
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem(selectNewItemVideoTopicPage);
		homePage.fillAndSaveNewVideoTopicPage(mainURL,valueBeta, valueVideoTopicPageInternalName, valueVideoTopicPageHeadline, valueVideoTopicPageFacebookDescription, valueVideoTopicPageMaxItems, valueVideoTopicPageItemsPerPage, valueVideoTopicPageSearchCriteria, valueVideoTopicPageRelatedLink, valueVideoTopicPageCustomTemplatePath, valueVideoTopicPageJavascriptPath, valueVideoTopicPageStylesheetPath, valueVideoTopicPageCustomPanel, valueVideoTopicPageTwitterHandle, valueVideoTopicPagePollKey, valueMajorTagToolPlayer);
		return;
	}	

  	@Test
	public void homeBaseTestMLB072CreateSaveBetaNewTwitterHandle() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(getDriver());
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem(selectNewItemTwitterHandle);
		homePage.fillAndSaveNewTwitterHandle(mainURL,valueBeta, valueAudioScheduleInternalName, valueMajorTagToolPlayer);
		return;
	}	

  	@Test
	public void homeBaseTestMLB073CreateSaveBetaNewVideoClipList() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(getDriver());
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectNewItem(selectNewItemVideoClipList);
		homePage.fillAndSaveNewVideoClipList(mainURL,valueBeta, valueVideoClipListInternalName, valueVideoClipListHeadline, valueVideoClipListListDefaultView, valueMajorTagToolPlayer);
		return;
	}	

  	@Test
	public void homeBaseTestMLB074UploadPhotos() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(getDriver());
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.selectHomePageUploadPhotos();
		homePage.uploadPhotos(mainURL, valueMajorTagToolPlayer);
		return;
	}	

  	@Test
	public void homeBaseTestMLB075DepthChart() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(getDriver());
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.depthChartsDeletePlayers(mainURL);
		homePage.depthChartsAddPlayers(mainURL);
		homePage.depthChartsRepositionPlayers(mainURL);
		homePage.depthChartsDeletePlayers(mainURL);
		return;
	}	

  	@Test
	public void homeBaseTestMLB076TeamContentProbables() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(getDriver());
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.probablesTeamContentAddPlayers(mainURL, valueProbablesTeamContentDateChangerMonth, valueProbablesTeamContentDateChangerDate, valueProbablesTeamContentDateChangerYear);
		homePage.probablesTeamContentRepositionPlayers(mainURL, valueProbablesTeamContentDateChangerMonth, valueProbablesTeamContentDateChangerDate, valueProbablesTeamContentDateChangerYear);
		homePage.probablesTeamContentDeletePlayers(mainURL, valueProbablesTeamContentDateChangerMonth, valueProbablesTeamContentDateChangerDate, valueProbablesTeamContentDateChangerYear);
		return;
	}	

  	@Test
	public void homeBaseTestMLB077GameContentProbables() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(getDriver());
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.probablesGameContentAddPlayers(mainURL, valueProbablesGameContentDateChangerMonth, valueProbablesGameContentDateChangerDate, valueProbablesGameContentDateChangerYear);
		homePage.probablesGameContentDeletePlayers(mainURL, valueProbablesGameContentDateChangerMonth, valueProbablesGameContentDateChangerDate, valueProbablesGameContentDateChangerYear);
		return;
	}	

  	@Test
	public void homeBaseTestMLB078GameContentLineup() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(getDriver());
		homePage.login(loginUser,loginPassword,majorLeagueSiteSelection);
		homePage.oldUIToNewUI(majorLeagueSiteSelection);
		homePage.lineupGameContentDeletePlayers(mainURL);
		homePage.lineupGameContentAddPlayers(mainURL);
		homePage.lineupGameContentDeletePlayers(mainURL);
		return;
	}	

	
	//************ MAJOR LEAGUE TESTS ************//
	//************ MAJOR LEAGUE TESTS ************//
	//************ MAJOR LEAGUE TESTS ************//

	
	//************ MINOR LEAGUE TESTS ************//
	//************ MINOR LEAGUE TESTS ************//
	//************ MINOR LEAGUE TESTS ************//
	
  	@Test
	public void homeBaseTestMiLB001Login() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(getDriver());
		homePage.login(loginUser,loginPassword,minorLeagueSiteSelection);
		homePage.oldUIToNewUI(minorLeagueSiteSelection);
		return;
	}	

  	@Test
	public void homeBaseTestMiLB002BasicSearch() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(getDriver());
		homePage.login(loginUser,loginPassword,minorLeagueSiteSelection);
		homePage.oldUIToNewUI(minorLeagueSiteSelection);
		homePage.basicSearch(valueBasicSearch);
		return;
	}	

  	@Test
	public void homeBaseTestMiLB003CreateSaveBetaNewArticle() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(getDriver());
		homePage.login(loginUser,loginPassword,minorLeagueSiteSelection);
		homePage.oldUIToNewUI(minorLeagueSiteSelection);
		homePage.selectNewItem(selectNewItemArticle);
		homePage.fillAndSaveNewArticle(mainURL,valueBeta,valueArticleInternalName,valueArticleHeadline,valueArticleSubhead,valueArticleAltHeadline,valueArticleByline,valueArticleSeoHeadline,valueArticlePoll,valueMinorTagToolPlayer,valueArticleBlurb, valueArticleNotes,valueArticleTagline);
		return;
	}	

  	@Test
	public void homeBaseTestMiLB004CreateSaveBetaNewDigitalAsset() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(getDriver());
		homePage.login(loginUser,loginPassword,minorLeagueSiteSelection);
		homePage.oldUIToNewUI(minorLeagueSiteSelection);
		homePage.selectNewItem(selectNewItemDigitalAsset);
		homePage.fillAndSaveNewDigitalAsset(mainURL,valueBeta, valueDigitalAssetInternalName,valueDigitalAssetHeadline, valueMinorTagToolPlayer);
		return;
	}	

  	@Test
	public void homeBaseTestMiLB005CreateSaveBetaNewFieldOption() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(getDriver());
		homePage.login(loginUser,loginPassword,minorLeagueSiteSelection);
		homePage.oldUIToNewUI(minorLeagueSiteSelection);
		homePage.selectNewItem(selectNewItemFieldOption);
		homePage.fillAndSaveNewFieldOption(mainURL,valueBeta, valueFieldOptionInternalName,valueFieldOptionDisplayName,valueFieldOptionValue,valueMinorTagToolPlayer);
		return;
	}	

  	@Test
	public void homeBaseTestMiLB006CreateSaveBetaNewHighlight() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(getDriver());
		homePage.login(loginUser,loginPassword,minorLeagueSiteSelection);
		homePage.oldUIToNewUI(minorLeagueSiteSelection);
		homePage.selectNewItem(selectNewItemHighlight);
		homePage.fillAndSaveNewHighlight(mainURL,valueBeta, valueHighlightInternalName,valueHighlightYear,valueMinorTagToolPlayer);
		return;
	}	

  	@Test
	public void homeBaseTestMiLB007CreateSaveBetaNewHTMLPage() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(getDriver());
		homePage.login(loginUser,loginPassword,minorLeagueSiteSelection);
		homePage.oldUIToNewUI(minorLeagueSiteSelection);
		homePage.selectNewItem(selectNewItemHTMLPage);
		homePage.fillAndSaveNewHTMLPage(mainURL,valueBeta, valueHTMLPageInternalName,valueHTMLPageHeadline,valueHTMLPageBlurb, valueMinorTagToolPlayer);
		return;
	}	

  	@Test
	public void homeBaseTestMiLB008CreateSaveBetaNewLink() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(getDriver());
		homePage.login(loginUser,loginPassword,minorLeagueSiteSelection);
		homePage.oldUIToNewUI(minorLeagueSiteSelection);
		homePage.selectNewItem(selectNewItemLink);
		homePage.fillAndSaveNewLink(mainURL,valueBeta, valueLinkInternalName,valueLinkLinkText,valueLinkLinkURL, valueLinkWidth,valueLinkHeight, valueMinorTagToolPlayer);
		return;
	}	

  	@Test
	public void homeBaseTestMiLB009CreateSaveBetaNewMediaWallPanel() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(getDriver());
		homePage.login(loginUser,loginPassword,minorLeagueSiteSelection);
		homePage.oldUIToNewUI(minorLeagueSiteSelection);
		homePage.selectNewItem(selectNewItemMediawallPanel);
		homePage.fillAndSaveNewMediaWallPanel(mainURL,valueBeta, valueMediawallPanelInternalName,valueMediawallPanelHeadline,valueMediawallPanelURLText, valueMediawallPanelURL,valueMediawallPanelMobileURL,valueMediawallPanelSponsorURL,valueMediawallPanelBlurb,valueMediawallPanelNotes, valueMediawallPanelDisplayTimeInSeconds, valueMediawallPanelVideoAlias, valueMinorTagToolPlayer);
		return;
	}	

  	@Test
	public void homeBaseTestMiLB010CreateSaveBetaNewNotebook() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(getDriver());
		homePage.login(loginUser,loginPassword,minorLeagueSiteSelection);
		homePage.oldUIToNewUI(minorLeagueSiteSelection);
		homePage.selectNewItem(selectNewItemNotebook);
		homePage.fillAndSaveNewNotebook(mainURL,valueBeta, valueNotebookInternalName,valueNotebookHeadline,valueNotebookByline,valueNotebookSource, valueNotebookTagline, valueMinorTagToolPlayer);
		return;
	}	

  	@Test
	public void homeBaseTestMiLB011CreateSaveBetaNewPhotoGallery() throws InterruptedException, UnsupportedEncodingException, AWTException, IOException
	{
		HB_HomePage homePage = new HB_HomePage(getDriver());
		homePage.login(loginUser,loginPassword,minorLeagueSiteSelection);
		homePage.oldUIToNewUI(minorLeagueSiteSelection);
		homePage.selectNewItem(selectNewItemPhotoGallery);
		homePage.fillAndSaveNewPhotoGallery(mainURL,valueBeta, valuePhotoGalleryInternalName,valuePhotoGalleryTitle,valuePhotoGallerySpanishTitle,valuePhotoGalleryBlurb,valuePhotoGallerySpanishBlurb, valueMinorTagToolPlayer);
		return;
	}	

	//************ MINOR LEAGUE TESTS ************//
	//************ MINOR LEAGUE TESTS ************//
	//************ MINOR LEAGUE TESTS ************//


}
