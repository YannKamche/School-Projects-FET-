import React from 'react'
import './services.css'
import {BiCheck} from 'react-icons/bi'

const Services = () => {
  return (
    <section id='services'>
      <h5>What I offer</h5>
      <h2>Services</h2>

      <div className="container services__container">
        <article className="service">
          <div className="service__head">
            <h3>UI/UX Designer</h3>
          </div>

          <ul className='service__list'>
            <li>
              <BiCheck className='service__list-icon'></BiCheck>
              <p>User Interface</p>
            </li>
            <li>
              <BiCheck className='service__list-icon'></BiCheck>
              <p>User Experience</p>
            </li>
            <li>
              <BiCheck className='service__list-icon'></BiCheck>
              <p>Product Design</p>
            </li>
           
          </ul>
        </article>
        {/* END OF UI/UX FIELD */}
         <article className="service">
          <div className="service__head">
            <h3>Web development</h3>
          </div>

          <ul className='service__list'>
            <li>
              <BiCheck className='service__list-icon'></BiCheck>
              <p>Frontend Development</p>
            </li>
            <li>
              <BiCheck className='service__list-icon'></BiCheck>
              <p>Backend Development</p>
            </li>
            <li>
              <BiCheck className='service__list-icon'></BiCheck>
              <p>Penetration Testing</p>
            </li>
            <li>
              <BiCheck className='service__list-icon'></BiCheck>
              <p>Software Testing</p>
            </li>
         
          </ul>
        </article>
            {/* WEB DEVELOPMENT ENDS*/}
         <article className="service">
          <div className="service__head">
            <h3>Mobile Development</h3>
          </div>

          <ul className='service__list'>
            <li>
              <BiCheck className='service__list-icon'></BiCheck>
              <p>Modern UI App</p>
            </li>
            <li>
              <BiCheck className='service__list-icon'></BiCheck>
              <p>App Optimisation</p>
            </li>
            <li>
              <BiCheck className='service__list-icon'></BiCheck>
              <p>App Customisation</p>
            </li>
          </ul>
        </article>
      </div>
    </section>
  )
}

export default Services