const mongoose = require('mongoose');

const testimonialModel = new mongoose.model('testimonials', mongoose.Schema({
    _id: String,
    avatar: String,
    name: String,
    review: String,
}))

module.exports = {
    testimonialModel
}