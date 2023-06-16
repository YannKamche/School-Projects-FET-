import React from 'react'
import './experience.css'
import { BsPatchCheckFill } from 'react-icons/bs'

const Experience = () => {
  return (
    <section id='experience'>
      <h5>What Skills I Have</h5>
      <h2>My Experience</h2>

      <div className="container experience__container">
        <div className="experience__frontend">
          <h3>
            Frontend Development
          </h3>
          <div className="experience__container">
            <article className='experience__details'>
              <BsPatchCheckFill className='experience__details-icon' />
              <div>
              <h4>HTML</h4>
              <small className='text-light'>Experienced</small>
              </div>
            </article>
             <article className='experience__details'>
              <BsPatchCheckFill className='experience__details-icon' />
              <div>
              <h4>CSS</h4>
              <small className='text-light'>Intermediate</small>
              </div>
            </article>
             <article className='experience__details'>
              <BsPatchCheckFill className='experience__details-icon' />
              <div>
              <h4>JavaScript</h4>
              <small className='text-light'>Experienced</small>
              </div>
            </article>
             <article className='experience__details'>
              <BsPatchCheckFill />
              <div>
              <h4>React</h4>
              <small className='text-light'>Experienced</small>
              </div>
            </article>
            <article className='experience__details'>
              <BsPatchCheckFill className='experience__details-icon' />
              <div>
              <h4>Tailwind CSS</h4>
              <small className='text-light'>Experienced</small>
              </div>
            </article>
          </div>
        </div>
      
        {/* End of Frontend */}


        <div className="experience__backend">
          <h3>Mobile Development</h3>
           <div className="experience__container">
            <article className='experience__details'>
              <BsPatchCheckFill />
              <div>
              <h4>Flutter</h4>
              <small className='text-light'>Experienced</small>
              </div>
            </article>
             <article className='experience__details'>
              <BsPatchCheckFill />
              <div>
              <h4>Dart</h4>
              <small className='text-light'>Intermediate</small>
              </div>
            </article>
             <article className='experience__details'>
              <BsPatchCheckFill />
              <div>
              <h4>Firebase</h4>
              <small className='text-light'>Basic</small>
              </div>
            </article>
            
           </div>
           </div>
         </div>
    

      
    </section>
  )
}

export default Experience
