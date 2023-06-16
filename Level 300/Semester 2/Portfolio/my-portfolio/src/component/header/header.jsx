import React from 'react'
import './header.css'
import './CTA'
import CTA from './CTA' //here we import the CTA component inside our header
import me from '.././../assets/me-without-bg.png'
import HeaderSocial from './HeaderSocial' //import of headerSocial component
export const Header = () => {
return (
<header>
<div className='container header__container'>
<h5>Hello I'm</h5>
<h1>Yann Kamche</h1>
<h5 className='text-light'>Frontend Web Developer</h5>
<CTA/>
{/* here we are using the imported CTA component */}
<HeaderSocial/>
{/* same here */}
<div className='my_image'>


 <img src= {me} alt="Yann kamche" />

</div>
<a href='#contact' className='scroll__down'>Scroll down</a>
</div>
</header>
)
}
export default Header;