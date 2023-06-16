import React from 'react'
import './portfolio.css'
import Portfolio1 from '../../assets/portfolio1.jpeg'
import Portfolio2 from '../../assets/portfolio2.jpeg'
import Portfolio3 from '../../assets/portfolio3.jpeg'
import Portfolio4 from '../../assets/portfolio4.jpeg'

const Portfolio = () => {
  return (
    <section id='portfolio'>
      <h5>My Recent Work</h5>
      <h2>Portfolio</h2>

      <div className="container portfolio__container">
         <article className='portfolio__item'>
          <div className="portfolio__item-image">
            <img src={Portfolio1} alt="Glassmorphic Bank card" />
          </div>
          <h3>This is a portfolio item title</h3>
          <a href="https://githup.com" className='btn'>Github</a>
          <a href="https://githup.com/YannKamche/" className='btn btn-primary' target='_blank'>Live Demo</a>
         </article>

         <article className='portfolio__item'>
          <div className="portfolio__item-image">
            <img src={Portfolio4} alt="Glassmorphic Bank card" />
          </div>
          <h3>This is a portfolio item title</h3>
          <a href="https://githup.com" className='btn'>Github</a>
          <a href="https://githup.com/YannKamche/" className='btn btn-primary' target='_blank'>Live Demo</a>
         </article>


         <article className='portfolio__item'>
          <div className="portfolio__item-image">
            <img src={Portfolio2} alt="Glassmorphic Bank card" />
          </div>
          <h3>This is a portfolio item title</h3>
          <a href="https://githup.com" className='btn'>Github</a>
          <a href="https://githup.com/YannKamche/" className='btn btn-primary' target='_blank'>Live Demo</a>
         </article>

         <article className='portfolio__item'>
          <div className="portfolio__item-image">
            <img src={Portfolio3} alt="Clothing Website" />
          </div>
          <h3>This is a portfolio item title</h3>
          <a href="https://githup.com" className='btn'>Github</a>
          <a href="https://githup.com/YannKamche/" className='btn btn-primary' target='_blank'>Live Demo</a>
         </article>

         <article className='portfolio__item'>
          <div className="portfolio__item-image">
            <img src={Portfolio4} alt="Slider" />
          </div>
          <h3>This is a portfolio item title</h3>
          <a href="https://githup.com" className='btn'>Github</a>
          <a href="https://githup.com/YannKamche/" className='btn btn-primary' target='_blank'>Live Demo</a>
         </article>

         <article className='portfolio__item'>
          <div className="portfolio__item-image">
            <img src={Portfolio2} alt="Shopping Website" />
          </div>
          <h3>This is a portfolio item title</h3>
          <a href="https://githup.com" className='btn'>Github</a>
          <a href="https://githup.com/NyandoOnongwene/" className='btn btn-primary' target='_blank'>Live Demo</a>
         </article>
        
      </div>

       
    </section>
  )
}

export default Portfolio