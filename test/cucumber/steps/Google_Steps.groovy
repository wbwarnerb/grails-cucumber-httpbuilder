import cucumber.runtime.PendingException
import groovyx.net.http.HTTPBuilder

import static cucumber.runtime.groovy.EN.*



Given(~'^I query google via their api$') { ->
    // Express the Regexp above with the code you wish you had
    http = new HTTPBuilder('http://www.google.com')
    html = http.get( path : '/search', query : [q:"Cucumber"])
}
Then(~'^a result is returned$') { ->
    // Express the Regexp above with the code you wish you had
    assert html instanceof groovy.util.slurpersupport.GPathResult
    assert html.HEAD.size() == 1
    assert html.BODY.size() == 1
}
Given(~'^I query google for "([^"]*)"$') { String arg1 ->
    // Express the Regexp above with the code you wish you had
    http = new HTTPBuilder('http://www.google.com')
    html = http.get( path : '/search', query : [q:"${arg1}"])
}
Then(~'^google will return a result with "([^"]*)"$') { String arg1 ->
    // Express the Regexp above with the code you wish you had
    assert html instanceof groovy.util.slurpersupport.GPathResult
    assert html.HEAD.size() == 1
    assert html.BODY.size() == 1
    assert html.HEAD =~ "${arg1}"
}