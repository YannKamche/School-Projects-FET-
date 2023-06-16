import React from 'react'
import './contact.css'
import {MdOutlineEmail} from 'react-icons/md'
import {AiOutlineLinkedin} from 'react-icons/ai'
import {BsWhatsapp} from 'react-icons/bs'
import { useRef } from 'react'
import emailjs from 'emailjs-com'

const Contact = () => {
 const form = useRef();
  
 const sendEmail = (e) => {
    e.preventDefault();

    emailjs.sendForm('service_6f3703m', 'template_maoygj9', form.current, 'Ft9NHMfHgL3rkuOip')
    
    e.target.reset()
  };

  return (

<section id="contact">
<h5>Get in touch</h5>
<h2>Contact me</h2>
<div className="container contact__container">
<div className="contact__options">
<article className='contact__option'>
<MdOutlineEmail className='contact__option__icon'/>

<h4>Email</h4>
<h5>yannkamche@gmail.com</h5>
<a href='mailto:yannkamche@gmail.com' target='_blank' rel='' >send a message</a>
</article>
<article className='contact__option'>
<AiOutlineLinkedin className='contact__option__icon'/>

<h4>LinkedIn</h4>
<h5>Profile</h5>
<a href='https://www.linkedin.com/in/yann-kamche-865530248/' rel=''
target='_blank' >Tap me on LinkedIn</a>
</article>
<article className='contact__option'>
<BsWhatsapp className='contact__option__icon'/>

<h4>Whatsapp</h4>
<h5>Direct message</h5>
<a href='https://web.whatsapp.com/send?phone=+237695554495' rel=''
target='_blank'>Whatsapp me</a>
</article>
</div>

<form ref={form} onSubmit={sendEmail}>
 <div>  
<input type="text" name='name' placeholder='full name' required

   
/>
</div>
<div>
<input type="email" name='email' placeholder='your email' required/>
</div>
<div>
<textarea name="message" id="message" cols="30" rows="10"
placeholder='your message' required></textarea>
</div>
<div>
<button type="submit" className='btn btn-primary'>send message</button>
</div>
</form>
</div>
</section>
)
}
export default Contact