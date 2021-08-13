package tests;

import core.drivermanager.DriverModule;
import tests.pages.abstractpages.ContactDetailPage;
import tests.pages.abstractpages.ContactSearchPage;
import tests.pages.android.AndroidContactDetailPage;
import tests.pages.android.AndroidContactSearchPage;
import tests.pages.ios.IosContactDetailPage;
import tests.pages.ios.IosContactSearchPage;

public class PageModule extends DriverModule {

    @Override
    protected void configure() {
        // cách 1: bind with annotation
//        bind(ContactSearchPage.class).annotatedWith(Names.named("android")).to(AndroidContactSearchPage.class);
//        bind(ContactSearchPage.class).annotatedWith(Names.named("ios")).to(IosContactSearchPage.class);
//
//        bind(ContactDetailPage.class).annotatedWith(Names.named("android")).to(AndroidContactDetailPage.class);
//        bind(ContactDetailPage.class).annotatedWith(Names.named("ios")).to(IosContactDetailPage.class);

        // bind without annotation
        String platform = getPlatform();
        if(platform.equalsIgnoreCase("android")){
            bind(ContactSearchPage.class).to(AndroidContactSearchPage.class);
            bind(ContactDetailPage.class).to(AndroidContactDetailPage.class);
        } else if(platform.equalsIgnoreCase("ios")){
            bind(ContactSearchPage.class).to(IosContactSearchPage.class);
            bind(ContactDetailPage.class).to(IosContactDetailPage.class);
        }
    }


}
