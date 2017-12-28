using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace Bootcamp
{
    [TestClass]
    public class HelloWorldTest
    {
        [TestMethod]
        public void printText()
        {
            Console.WriteLine("Hello world");
        }
    }
}
