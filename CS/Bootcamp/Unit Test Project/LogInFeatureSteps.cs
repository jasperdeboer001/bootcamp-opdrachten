using System;
using TechTalk.SpecFlow;

namespace Unit_Test_Project
{
    [Binding]
    public class LogInFeatureSteps
    {
        [Given(@"I am on the home page")]
        public void GivenIAmOnTheHomePage()
        {
            ScenarioContext.Current.Pending();
        }
        
        [When(@"I enter a correct email")]
        public void WhenIEnterACorrectEmail()
        {
            ScenarioContext.Current.Pending();
        }
        
        [When(@"I enter a correct password")]
        public void WhenIEnterACorrectPassword()
        {
            ScenarioContext.Current.Pending();
        }
        
        [Then(@"should be able to login")]
        public void ThenShouldBeAbleToLogin()
        {
            ScenarioContext.Current.Pending();
        }
    }
}
