package com.mlb.qa.tests.web.ticketadmin;

import com.mlb.qa.gui.pages.ticketadmin.TicketAdmin_HomePage;
import com.qaprosoft.carina.core.foundation.UITest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.apache.commons.codec.binary.Base64;


public class TicketAdminTestSuite extends UITest {

    //************ TEXT FIELD VALUES ************//
    //************ TEXT FIELD VALUES ************//
    //************ TEXT FIELD VALUES ************//


    //************ LOGIN OBJECTS ************//
    private static final String mainURL = "https://bamutil.qa.mlb.com/ticketing-admin/login.jsp";
    public static String mainURL2 = "https://bamutil.qa.mlb.com/ticketing-admin/login.jsp";
    private static final String loginUser = "schudgar";
    private static final String loginPasswordEncrypted = "dWQzb2ZyVi4=";
    private static byte[] decryptedPasswordBytes = Base64.decodeBase64(loginPasswordEncrypted);
    private static final String loginPassword = new String(decryptedPasswordBytes);
    //************ LOGIN OBJECTS ************//

    private TicketAdmin_HomePage basePart(){
    	TicketAdmin_HomePage homePage = new TicketAdmin_HomePage(getDriver());
        homePage.login(loginUser, loginPassword);
        return homePage;
    }

//    @Test
    public void ticketingAdminTest000TestFunction() {
    	TicketAdmin_HomePage homePage = basePart();
    }

    @Test
    public void ticketingAdminTest001Login() {
    	TicketAdmin_HomePage homePage = basePart();
    }

   /* 
    
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

*/
    
    //************ MAJOR LEAGUE TESTS ************//
    //************ MAJOR LEAGUE TESTS ************//
    //************ MAJOR LEAGUE TESTS ************//

}