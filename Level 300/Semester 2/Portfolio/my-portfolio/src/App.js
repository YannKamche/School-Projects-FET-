
import './App.css';

// function App() {
//   return (
//     <div className="App">
//     <h1>Hello World</h1>
//     </div>
//   );
// }

// export default App;

import Header from './component/header/header';
import Navbar from './component/navbar/navbar';
import About from './component/about/about';
import Experience from './component/experience/experience';
import Services from './component/services/Services';
import Portfolio from './component/portolio/Portfolio';
import Testimonial from './component/testimonial/Testimonial';
import Contact from './component/contact/Contact';
import Footer from './component/footer/footer';

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