package com.example.countryinfo.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Ignore;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class CountriesModel implements Serializable {

    public CountriesModel() {
    }

    /**
     * name : Afghanistan
     * topLevelDomain : [".af"]
     * alpha2Code : AF
     * alpha3Code : AFG
     * callingCodes : ["93"]
     * capital : Kabul
     * altSpellings : ["AF","Afġānistān"]
     * region : Asia
     * subregion : Southern Asia
     * population : 27657145
     * latlng : [33,65]
     * demonym : Afghan
     * area : 652230.0
     * gini : 27.8
     * timezones : ["UTC+04:30"]
     * borders : ["IRN","PAK","TKM","UZB","TJK","CHN"]
     * nativeName : افغانستان
     * numericCode : 004
     * currencies : [{"code":"AFN","name":"Afghan afghani","symbol":"؋"}]
     * languages : [{"iso639_1":"ps","iso639_2":"pus","name":"Pashto","nativeName":"پښتو"},{"iso639_1":"uz","iso639_2":"uzb","name":"Uzbek","nativeName":"Oʻzbek"},{"iso639_1":"tk","iso639_2":"tuk","name":"Turkmen","nativeName":"Türkmen"}]
     * translations : {"de":"Afghanistan","es":"Afganistán","fr":"Afghanistan","ja":"アフガニスタン","it":"Afghanistan","br":"Afeganistão","pt":"Afeganistão","nl":"Afghanistan","hr":"Afganistan","fa":"افغانستان"}
     * flag : https://restcountries.eu/data/afg.svg
     * regionalBlocs : [{"acronym":"SAARC","name":"South Asian Association for Regional Cooperation","otherAcronyms":[],"otherNames":[]}]
     * cioc : AFG
     */

    @SerializedName("name")
    private String name;
    @SerializedName("alpha2Code")
    private String alpha2Code;
    @SerializedName("alpha3Code")
    private String alpha3Code;
    @SerializedName("capital")
    private String capital;
    @SerializedName("region")
    private String region;
    @SerializedName("subregion")
    private String subregion;
    @SerializedName("population")
    private int population;
    @SerializedName("demonym")
    private String demonym;
    @SerializedName("area")
    private double area;
    @SerializedName("gini")
    private double gini;
    @SerializedName("nativeName")
    private String nativeName;
    @SerializedName("numericCode")
    private String numericCode;
    @Ignore
    @SerializedName("translations")
    private TranslationsBean translations;
    @SerializedName("flag")
    private String flag;
    @SerializedName("cioc")
    private String cioc;
    @Ignore
    @SerializedName("topLevelDomain")
    private List<String> topLevelDomain;

    @Ignore
    @SerializedName("callingCodes")
    private List<String> callingCodes;

    @Ignore
    @SerializedName("altSpellings")
    private List<String> altSpellings;

    @Ignore
    @SerializedName("latlng")
    private List<Double> latlng;

    @Ignore
    @SerializedName("timezones")
    private List<String> timezones;

    @Ignore
    @SerializedName("borders")
    private List<String> borders;
    @Ignore
    @SerializedName("currencies")
    private List<CurrenciesBean> currencies;

    @Embedded
    @SerializedName("languages")
    private List<LanguagesBean> languages;

    @Ignore
    @SerializedName("regionalBlocs")
    private List<RegionalBlocsBean> regionalBlocs;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlpha2Code() {
        return alpha2Code;
    }

    public void setAlpha2Code(String alpha2Code) {
        this.alpha2Code = alpha2Code;
    }

    public String getAlpha3Code() {
        return alpha3Code;
    }

    public void setAlpha3Code(String alpha3Code) {
        this.alpha3Code = alpha3Code;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getSubregion() {
        return subregion;
    }

    public void setSubregion(String subregion) {
        this.subregion = subregion;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getDemonym() {
        return demonym;
    }

    public void setDemonym(String demonym) {
        this.demonym = demonym;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getGini() {
        return gini;
    }

    public void setGini(double gini) {
        this.gini = gini;
    }

    public String getNativeName() {
        return nativeName;
    }

    public void setNativeName(String nativeName) {
        this.nativeName = nativeName;
    }

    public String getNumericCode() {
        return numericCode;
    }

    public void setNumericCode(String numericCode) {
        this.numericCode = numericCode;
    }

    public TranslationsBean getTranslations() {
        return translations;
    }

    public void setTranslations(TranslationsBean translations) {
        this.translations = translations;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getCioc() {
        return cioc;
    }

    public void setCioc(String cioc) {
        this.cioc = cioc;
    }

    public List<String> getTopLevelDomain() {
        return topLevelDomain;
    }

    public void setTopLevelDomain(List<String> topLevelDomain) {
        this.topLevelDomain = topLevelDomain;
    }

    public List<String> getCallingCodes() {
        return callingCodes;
    }

    public void setCallingCodes(List<String> callingCodes) {
        this.callingCodes = callingCodes;
    }

    public List<String> getAltSpellings() {
        return altSpellings;
    }

    public void setAltSpellings(List<String> altSpellings) {
        this.altSpellings = altSpellings;
    }

    public List<Double> getLatlng() {
        return latlng;
    }

    public void setLatlng(List<Double> latlng) {
        this.latlng = latlng;
    }

    public List<String> getTimezones() {
        return timezones;
    }

    public void setTimezones(List<String> timezones) {
        this.timezones = timezones;
    }

    public List<String> getBorders() {
        return borders;
    }

    public void setBorders(List<String> borders) {
        this.borders = borders;
    }

    public List<CurrenciesBean> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(List<CurrenciesBean> currencies) {
        this.currencies = currencies;
    }

    public List<LanguagesBean> getLanguages() {
        return languages;
    }

    public void setLanguages(List<LanguagesBean> languages) {
        this.languages = languages;
    }

    public List<RegionalBlocsBean> getRegionalBlocs() {
        return regionalBlocs;
    }

    public void setRegionalBlocs(List<RegionalBlocsBean> regionalBlocs) {
        this.regionalBlocs = regionalBlocs;
    }

    public static class TranslationsBean {
        /**
         * de : Afghanistan
         * es : Afganistán
         * fr : Afghanistan
         * ja : アフガニスタン
         * it : Afghanistan
         * br : Afeganistão
         * pt : Afeganistão
         * nl : Afghanistan
         * hr : Afganistan
         * fa : افغانستان
         */

        @SerializedName("de")
        private String de;
        @SerializedName("es")
        private String es;
        @SerializedName("fr")
        private String fr;
        @SerializedName("ja")
        private String ja;
        @SerializedName("it")
        private String it;
        @SerializedName("br")
        private String br;
        @SerializedName("pt")
        private String pt;
        @SerializedName("nl")
        private String nl;
        @SerializedName("hr")
        private String hr;
        @SerializedName("fa")
        private String fa;

        public String getDe() {
            return de;
        }

        public void setDe(String de) {
            this.de = de;
        }

        public String getEs() {
            return es;
        }

        public void setEs(String es) {
            this.es = es;
        }

        public String getFr() {
            return fr;
        }

        public void setFr(String fr) {
            this.fr = fr;
        }

        public String getJa() {
            return ja;
        }

        public void setJa(String ja) {
            this.ja = ja;
        }

        public String getIt() {
            return it;
        }

        public void setIt(String it) {
            this.it = it;
        }

        public String getBr() {
            return br;
        }

        public void setBr(String br) {
            this.br = br;
        }

        public String getPt() {
            return pt;
        }

        public void setPt(String pt) {
            this.pt = pt;
        }

        public String getNl() {
            return nl;
        }

        public void setNl(String nl) {
            this.nl = nl;
        }

        public String getHr() {
            return hr;
        }

        public void setHr(String hr) {
            this.hr = hr;
        }

        public String getFa() {
            return fa;
        }

        public void setFa(String fa) {
            this.fa = fa;
        }
    }

    public static class CurrenciesBean {
        /**
         * code : AFN
         * name : Afghan afghani
         * symbol : ؋
         */

        @SerializedName("code")
        private String code;
        @SerializedName("name")
        private String name;
        @SerializedName("symbol")
        private String symbol;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSymbol() {
            return symbol;
        }

        public void setSymbol(String symbol) {
            this.symbol = symbol;
        }
    }

    public static class LanguagesBean {
        /**
         * iso639_1 : ps
         * iso639_2 : pus
         * name : Pashto
         * nativeName : پښتو
         */

        @SerializedName("iso639_1")
        private String iso6391;
        @SerializedName("iso639_2")
        private String iso6392;
        @SerializedName("name")
        private String name;
        @SerializedName("nativeName")
        private String nativeName;

        public String getIso6391() {
            return iso6391;
        }

        public void setIso6391(String iso6391) {
            this.iso6391 = iso6391;
        }

        public String getIso6392() {
            return iso6392;
        }

        public void setIso6392(String iso6392) {
            this.iso6392 = iso6392;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getNativeName() {
            return nativeName;
        }

        public void setNativeName(String nativeName) {
            this.nativeName = nativeName;
        }
    }

    public static class RegionalBlocsBean {
        /**
         * acronym : SAARC
         * name : South Asian Association for Regional Cooperation
         * otherAcronyms : []
         * otherNames : []
         */

        @SerializedName("acronym")
        private String acronym;
        @SerializedName("name")
        private String name;
        @SerializedName("otherAcronyms")
        private List<?> otherAcronyms;
        @SerializedName("otherNames")
        private List<?> otherNames;

        public String getAcronym() {
            return acronym;
        }

        public void setAcronym(String acronym) {
            this.acronym = acronym;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<?> getOtherAcronyms() {
            return otherAcronyms;
        }

        public void setOtherAcronyms(List<?> otherAcronyms) {
            this.otherAcronyms = otherAcronyms;
        }

        public List<?> getOtherNames() {
            return otherNames;
        }

        public void setOtherNames(List<?> otherNames) {
            this.otherNames = otherNames;
        }
    }
}