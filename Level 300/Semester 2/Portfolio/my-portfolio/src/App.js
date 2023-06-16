
import './App.css';

// function App() {
//   return (
//     <div className="App">
//     <h1>Hello World</h1>
//     </div>
//   );
// }

// export default App;

import Header from './component/header/Header';
import Navbar from './component/navbar/Navbar';
import About from './component/about/About';
import Experience from './component/experience/Experience';
import Services from './component/services/Services';
import Portfolio from './component/portfolio/Portfolio';
import Testimonial from './component/testimonial/Testimonial';
import Contact from './component/contact/Contact';
import Footer from './component/footer/Footer';

function App() {
return (
<div>
  <Header />
  <Navbar />
  <About />
  <Experience />
  <Services />
  <Portfolio />
  <Testimonial />
  <Contact />
  <Footer />
</div>

);
}
export default App; 