const { portfolioSchema } = require('../model/portfolio_model');
const { testimonialModel } = require('../model/testimonial_model');


exports.portfolioAppRoute = async (req, res) => {
  try {

    items = await portfolioSchema.find({});


    return res.status(200).send({
      message: 'Success',
      data: items
    });
  } catch (error) {
  
    res.status(500).json({ error: 'Internal server error' });
  }
}

exports.testimonialRoute = async (req, res) => {
  try {
    
    items = await testimonialModel.find({});

    return res.status(200).send({
      message: "Success",
      data: items
    });


  } catch (error) {
    res.status(500).json({ error: 'Internal server error' });

  }
}

