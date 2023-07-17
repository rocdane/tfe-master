import './App.css';
import Header from './components/Header';
import Hero from './components/Hero';
import About from './components/About';
import Feature from './components/Feature';
import Perspective from './components/Perspective';
import Footer from './components/Footer';
import Top from './components/Top';


function App() {

  window.onscroll = function(){
    const jump = document.getElementById("top");

    if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {
      jump.style.display = "block";
    } else {
      jump.style.display = "none";
    }
  }

  return (
    <div className="App">
      <Header></Header>
      <Hero></Hero>
      <About></About>
      <Feature></Feature>
      <Perspective></Perspective>
      <Footer></Footer>
      <Top></Top>
    </div>
  );
}

export default App;
