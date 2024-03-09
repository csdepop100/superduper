package de.brockhaus_ag.superduper;

import de.brockhaus_ag.superduper.repository.ProductRepositoryDemoImpl;

public class DemoMain {
    /*
    About comments in code: I prefer to keep my code 100% in English, as I don't want to be bothered
    with encryption or any compiler spitting warnings for using umlauts.
    Usually I avoid commenting code and only use it to take notes during the development
    process or for todos.

    I like to have my Main class to be as minimalistic as possible that's why I decided to put all
    the demo logic into a DemoRunner class. The second reason why I split the demo code is to have
    the feel of (manual) dependency injection while not working with Spring. I felt like using
    Spring here would be overkill, so we keep the dependencies nice and tidy.

    Speaking of dependencies, I included the apache commons-lang3 lib because I just love the
    utility classes. Sometimes I feel like java as a langauge is a bit rough around the corners
    and the development experience can be a little bit dry but those util classes make statements
    like boolean not so much more readable and handling of Strings so much easier.
     */
    public static void main(String[] args) {
        var repo = new ProductRepositoryDemoImpl();
        var runner = new DemoRunner(repo);
        runner.listProducts();
    }
}