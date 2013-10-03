package ru.terra.terramarket.constants;

public class URLConstants {
	public static final String SERVER_URL = "http://localhost:18080/terramarket/";

    public class Pages {
        public static final String SPRING_LOGIN = "/terramarket/do.login";
        public static final String HOME = "/";
        public static final String ERROR404 = "error404";
        public static final String LOGIN = "login";
        public static final String MARKET_HOME = "market";
        public static final String REG = "reg";
        public static final String PRICE = "price";
        public static final String STORE = "store";
        public static final String REPORTS = "reports";
        public static final String SELL = "sell";
        public static final String MISC_DEFICIT = "misc/deficit";
        public static final String MISC_ADMIN = "misc/admin";
        public static final String SETTINGS = "settings";
        public static final String ABOUT = "about";
        public static final String PRODUCTS = "products";
        public static final String PRODUCT = "product";
        public static final String ADMIN = "admin";
        public static final String GROUPS = "groups";
        public static final String GROUP = "group";
        public static final String WAYBILLS = "waybills";
        public static final String WAYBILL = "waybill";
    }

    public class DoJson {

        public static final String DO_LIST = "do.list.json";
        public static final String DO_GET = "do.get.json";
        public static final String DO_DEL = "do.delete.json";
        public static final String DO_CREATE = "do.create.json";
        public static final String DO_UPDATE = "do.update.json";

        public class Login {
            public static final String LOGIN = "/login/";
            public static final String LOGIN_DO_LOGIN_JSON = "do.login.json";
            public static final String LOGIN_DO_REGISTER_JSON = "do.register.json";
            public static final String LOGIN_DO_GET_MY_ID = "do.getmyid.json";
            public static final String LOGIN_PARAM_USER = "user";
            public static final String LOGIN_PARAM_PASS = "pass";
        }

        public class Sell {
            public static final String SELL = "/sell/";
            public static final String SELL_DO_SELL_JSON = "do.sell.json";
            public static final String GET_LAST_SELLS = "do.getlastsells.json";
        }

        public class Store {
            public static final String STORE = "/store/";
        }

        public class Product {
            public static final String PRODUCT = "/product/";
        }

        public class Group {
            public static final String GROUP = "/group/";
        }

        public class WayBill {
            public static final String WAYBILL = "/waybill/";
            public static final String UPDATE_ITEMS = "do.updateitems.json";
        }

    }

    public class Views {
        public static final String ERROR404 = "error404";
        public static final String LOGIN = "login";
        public static final String MARKET_HOME = "market";
        public static final String REG = "reg";
        public static final String PRICE = "price";
        public static final String STORE = "store";
        public static final String REPORTS = "reports";
        public static final String SELL = "sell";
        public static final String MISC_DEFICIT = "misc/deficit";
        public static final String MISC_ADMIN = "misc/admin";
        public static final String SETTINGS = "settings";
        public static final String ABOUT = "about";
        public static final String PRODUCTS = "products";
        public static final String ADMIN = "admin";
        public static final String PRODUCT = "product";
        public static final String GROUPS = "groups";
        public static final String GROUP = "group";
        public static final String WAYBILLS = "waybills";
        public static final String WAYBILL = "waybill";
    }
}
