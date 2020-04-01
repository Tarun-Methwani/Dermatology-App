package com.ind.sihc.pdapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class NoturgentActivity extends AppCompatActivity {

    TextView tvSymp1,tvSymp2,tvSymp3,tvSymp4,tvSymp5,tvSymp6,tvSymp7,tvSymp8,tvSymp9,tvSymp10,tvSymp11,tvSymp12,tvDiseasenup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noturgent);

        tvSymp1=findViewById(R.id.tvSymp1);
        tvSymp2=findViewById(R.id.tvSymp2);
        tvSymp3=findViewById(R.id.tvSymp3);
        tvSymp4=findViewById(R.id.tvSymp4);
        tvSymp5=findViewById(R.id.tvSymp5);
        tvSymp6=findViewById(R.id.tvSymp6);
        tvSymp7=findViewById(R.id.tvSymp7);
        tvSymp8=findViewById(R.id.tvSymp8);
        tvSymp9=findViewById(R.id.tvSymp9);
        tvSymp10=findViewById(R.id.tvSymp10);
        tvSymp11=findViewById(R.id.tvSymp11);
        tvSymp12=findViewById(R.id.tvSymp12);
        tvDiseasenup=findViewById(R.id.tvDiseasenup);




        tvSymp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(),RemediesNotUrgent.class);
                i.putExtra("symp1","Solution for red and white bumps");
                i.putExtra("sol1","DO wash your skin before treating it. \n" +
                        "DO apply ice to reduce pain and swelling.\n" +
                        "DO apply a product that contains 2 percent benzoyl peroxide to the pimple.\n" +
                        "DO apply a warm compress once a whitehead begins to form.\n.");
                startActivity(i);

            }
        });

        tvSymp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),RemediesNotUrgent.class);
                i.putExtra("symp2","Solution for itchy painful skin\n");
                i.putExtra("sol2","Dry the drool. \n" +
                        "For babies, spit can be a constant cause of skin irritation.\n" +
                        "\n" +
                        "\n" +
                        "Be gentle. \n" +
                        "Use fragrance- and dye-free cleansers and soaps. Harsh soaps can dry skin and break down its protective barrier.\n" +
                        "\n" +
                        "\n" +
                        "Clip nails short.\n" +
                        "Babies and most kids (and adults!) can’t fight the urge to scratch that itch. That won’t make the itch go away, but it will make raw, infected skin more likely.\n" +
                        "\n" +
                        "\n" +
                        "Bathe.\n" +
                        "Use lukewarm (not hot) water and avoid bubble baths. Keep baths short (3 to 5 minutes). A lengthy soak can dry out skin.\n" +
                        "\n" +
                        "\n" +
                        "Moisturize after a bath.\n" +
                        "Let hair dry or gently pat her skin dry. Then use an ointment or cream, and don't be afraid to slather it on. Ointments are more effective than creams, and creams are more effective than lotions. Lotion tends to be watery; oily ointments stick better and are better moisturizers.\n" +
                        "\n" +
                        "\n" +
                        "Dress her in soft cotton fabrics.\n" +
                        "Rough clothes can make her itch, which will make her scratch.\n" +
                        "\n" +
                        "Spot and treat an infection. \n" +
                        "If you see symptoms of a skin infection -- pus or very red, sore, raised, hot, or crusty skin -- call your doctor.\n.");
                startActivity(i);

            }
        });
        tvSymp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),RemediesNotUrgent.class);
                i.putExtra("symp3","Solution for scaly rough skin");
                i.putExtra("sol3","Moisturize after a bath.\n" +
                        "Let hair dry or gently pat her skin dry. Then use an ointment or cream, and don't be afraid to slather it on. Ointments are more effective than creams, and creams are more effective than lotions. Lotion tends to be watery; oily ointments stick better and are better moisturizers.\n" +
                        "\n" +
                        "\n" +
                        "Dress her in soft cotton fabrics.\n" +
                        "Rough clothes can make her itch, which will make her scratch.\n.");
                startActivity(i);

            }
        });
        tvSymp4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),RemediesNotUrgent.class);
                i.putExtra("symp4","Solution for peeling skin\n");
                i.putExtra("sol4","1. Take a pain reliever\n" +
                        "Take an over-the-counter (OTC) pain reliever such as ibuprofen (Advil) or aspirin (Bayer).\n" +
                        "\n" +
                        "These medications work to reduce the inflammation and redness surrounding your sunburn. They can also reduce the pain associated with having a sunburn.\n" +
                        "\n" +
                        "2. Use a soothing anti-inflammatory cream\n" +
                        "Apply a topical anti-inflammatory cream to your sunburn, such as aloe vera or cortisone cream.Or — as long as you aren’t allergic to aspirin — crush up a few aspirin tablets into a fine powder and add just enough water until it forms a goopy paste. Apply this to the areas of your body affected by sunburn.\n" +
                        "Avoid petroleum-based or other oil-based creams as these may trap heat and make your sunburn and peeling even worse.\n" +
                        "Try to moisturize right after you bathe, when your skin is still damp, to help seal in moisture.\n" +
                        "\n" +
                        "3. Take a cool bath\n" +
                        "Take a cool (just below lukewarm) bath. This can help ease the pain of your sunburn and stop your skin from peeling further.\n" +
                        "Avoid showering if your skin is blistered in addition to peeling, as showering may pop your blisters and trigger more peeling.\n" +
                        "Do not use soaps or bath oils when you bathe. These can make your peeling worse.\n" +
                        "\n" +
                        "4. Be gentle with your skin\n" +
                        "Avoid rubbing your skin with a towel after you bathe. This can make peeling worse. Instead, pat your skin dry with a towel.\n" +
                        "\n" +
                        "\n" +
                        "5. Make a cool compress\n" +
                        "Place a cool, wet compress on your skin for 20 to 30 minutes to soothe irritation and stop peeling.\n" +
                        "Be sure not to apply ice directly to your skin as that may cause further irritation.\n" +
                        "\n" +
                        "\n" +
                        "6. Stay hydrated\n" +
                        "Make sure you keep your skin hydrated by consuming at least eight 8-ounce glasses of clear liquids a day while you recover from your sunburn. This will help reduce peeling.\n" +
                        "\n" +
                        "7. Keep it covered\n" +
                        "Protect your peeling skin from further damage by keeping it covered with clothing or a very thin layer of sunscreen with an SPF of 45 or higher.\n.");
                startActivity(i);

            }
        });
        tvSymp5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),RemediesNotUrgent.class);
                i.putExtra("symp5","Dry Cracked Skin\n");
                i.putExtra("sol5","1. Coconut oil\n" +
                        "Coconut oil has emollient properties. Emollients fill the spaces between skin cells, creating a smooth surface. That’s why the saturated fatty acids that occur naturally in coconut oil can hydrate and smooth the skin.\n" +
                        "\n" +
                        "You can use coconut oil daily on even the most sensitive parts of your body. These include the area underneath your eyes and around your mouth. Another advantage of coconut oil is that you don’t need to mix it with anything. Coconut is gentle enough for substantial everyday use.\n" +
                        "\n" +
                        "2. Petroleum jelly\n" +
                        "According to a study, petroleum jelly products can heal skin in older adults. Petroleum jelly, also known as mineral oil, covers the skin in a protective layer. It traps moisture underneath. This helps heal dry, irritated skin patches.\n" +
                        "\n" +
                        "\n" +
                        "3. Oatmeal baths\n" +
                        "Oatmeal is common folk remedy for irritated skin. A 2015 study showed why grandmothers and great-grandmothers have been recommending this home remedy for centuries: It works.\n" +
                        "\n" +
                        "Colloidal oatmeal has antioxidants and anti-inflammatory properties that soothe irritation. This remedy is especially effective if you’re seeking to relieve itching. After you’ve taken an oatmeal bath, make sure you moisturize your skin to lock in the barrier.\n" +
                        "\n" +
                        "You can make an oatmeal bath at home. Use a food processor to chop oatmeal into a fine powder, then stir it into warm water. You can also try one of the many commercial products available to make an oatmeal soak.\n" +
                        "\n" +
                        "4. Antioxidants and omega-3s\n" +
                        "When your skin is dry, it means you’re exposing it to elements that are damaging skin cells faster than your body can repair them. There are some foods that can help your skin appear healthier, \n" +
                        "Foods rich in antioxidants can minimize damage from toxins and help your body make healthy cells. Some of the foods that contribute to skin health include:blueberries,tomatoes,carrots,beans,peas,lentils,\n" +
                        "Foods rich in omega-3 fatty acids like salmon, may also contribute to a glowing-skin diet.\n" +
                        "\n" +
                        "\n" +
                        "5. Gloves\n" +
                        "\n" +
                        "Get in the habit of wearing gloves when your hands are in water. Your hands also take a lot of abuse when temperatures drop and you’re working outside in the cold.\n" +
                        "\n" +
                        "\n" +
                        "6. Adjust your shower temperature\n" +
                        "The American Academy of Dermatology notes that relieving dry skin is sometimes as simple as changing your shower routine. While most people tend to take hot showers, these can scald the skin and cause damage.\n" +
                        "\n" +
                        "And some soaps that claim to moisturize and repair the skin can cause the opposite effect. They can trigger allergic reactions and make the skin thinner with harsh chemicals.\n" +
                        "\n" +
                        "Take short showers with water that’s warm, not hot. And look for soaps that are fragrance-free and gentler on skin than traditional soaps.\n" +
                        "\n" +
                        "7. Use a humidifier\n" +
                        "Keeping a humidifier in your home can help minimize the dryness caused by home heating systems. Though gas and electric heat strip moisture from the air, a humidifier set to 60 percent is enough to offset this effect, according to the Harvard Medical School.\n" +
                        "\n" +
                        "8. Avoid allergens and irritants\n" +
                        "A sudden occurrence of dry skin might be connected to the clothes you’re wearing or what you’ve exposed your skin to.\n" +
                        "\n" +
                        "Sitting by the fireplace, spending time in chlorinated or chemically-treated water, or even wearing wool clothing can all irritate your skin and make it feel dry. Check what you’re putting your skin through, and try to treat it gently.\n");
                startActivity(i);

            }
        });
        tvSymp6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),RemediesNotUrgent.class);
                i.putExtra("symp6","Discoloured Patch");
                i.putExtra("sol6"," Coconut oil and lemon juice\n" +
                        "Lemons are packed with vitamin C, which may help treat hyperpigmentation. Coconut oil can serve as a moisturizer, and it may help keep your thighs soft and supple.\n" +
                        "To make a coconut oil and lemon juice scrub:\n" +
                        "Combine a few tablespoons of coconut oil with the juice of half a lemon.\n" +
                        "Rub the mixture into the affected area and massage for 10 minutes or longer.\n" +
                        "Wash the area clean.\n" +
                        "Research suggests that certain formulations containing vitamin C may be more effective than others, so this method may not prove to be effective for you.\n.");
                startActivity(i);

            }
        });
        tvSymp7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),RemediesNotUrgent.class);
                i.putExtra("symp7","Ulcers");
                i.putExtra("sol7","Most mouth ulcers don’t need any medical treatment and can be cared for at home. In most cases, the ulcer will heal itself within a couple of weeks. The best thing to do in this instance is to ensure that the mouth ulcer is not irritating the baby or causing them pain. Our Sensiteeth Kids Aphthae Gel has been specially formulated to relieve the pain and irritation of mouth ulcers as they heal.\n" +
                        "\n" +
                        "Although it is usually safe to treat your baby’s mouth ulcer at home if you suspect they may be caused by a viral infection or if the mouth ulcers are recurring then you should consult a medical professional..");
                startActivity(i);

            }
        });
        tvSymp8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),RemediesNotUrgent.class);
                i.putExtra("symp8","open sores or lesions");
                i.putExtra("sol8","1. Turmeric\n" +
                        "The humble kitchen spice is a natural antiseptic and antibiotic agent that has been used for years for its medicinal uses. As per a study published in the journal Molecular and Cellular Biochemistry, the curcumin in turmeric helps boost wound healing by modulating collagen. If the wound is bleeding, apply turmeric on the wound; bleeding will immediately stop. Also drink a glass of turmeric milk every night before bedtime to heal completely.\n" +
                        "\n" +
                        "2. Honey\n" +
                        "\n" +
                        "Applying honey on the open wound helps dehydrate the bacteria from it and keeps infections at bay. Honey is well known for its anti-bacterial, anti-fungal and anti-inflammatory properties. Apply honey directly on the wound regularly before washing it.\n" +
                        "\n" +
                        "\n" +
                        "3. Aloe Vera\n" +
                        "Aloe Vera has analgesic, anti-inflammatory and soothing properties that ease the healing process. In fact, its gel has phytochemicals that help ease the pain and reduce inflammation. Cut open an aloe vera leaf and extract the gel. Apply the gel on the wound and let it dry. Clean the area with warm water and pat dry with a clean towel.");
                startActivity(i);
            }
        });
        tvSymp9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),RemediesNotUrgent.class);
                i.putExtra("symp9","solution for Skin Growth");
                i.putExtra("sol9","1. Tea tree oil\n" +
                        "Tea tree oil, which has antiviral and antifungal properties, is safe to use on the skin. First, wash the affected area. Then, using a Q-tip or cotton swab, gently massage the oil over the skin tag. Place a bandage over the area overnight. Repeat this treatment for several nights until the tag dries out and falls off the skin.\n" +
                        "\n" +
                        "2. Banana peel\n" +
                        "Don’t toss away your old banana peels, especially if you have a skin tag. The peel of a banana can also help dry out a skin tag. Place a piece of banana peel over the tag and cover it with a bandage. Do this nightly until the tag falls off.\n" +
                        "\n" +
                        "3. Apple cider vinegar\n" +
                        "Soak a cotton swab in apple cider vinegar, and then place the cotton swab over the skin tag. Wrap the section in a bandage for 15 to 30 minutes, and then wash the skin. Repeat daily for a couple of weeks. The acidity of apple cider vinegar breaks down the tissue surrounding the skin tag, causing it to fall off.\n" +
                        "\n" +
                        "4. Vitamin E\n" +
                        "Aging may contribute to skin tags. Since vitamin E is an antioxidant that fights wrinkles and keeps the skin healthy, applying liquid vitamin E over a skin tag may cause the growth to vanish in a couple of days. Simply massage the oil over the tag and the surrounding skin.\n" +
                        "\n" +
                        "5. Garlic\n" +
                        "Garlic has anti-aging benefits and helps improve the appearance of skin by reducing inflammation. To get rid of a skin tag naturally, apply crushed garlic over the tag, and then cover the area with a bandage overnight. Wash the area in the morning and repeat until the skin tag shrinks and disappears.\n.");
                startActivity(i);
            }
        });
        tvSymp10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),RemediesNotUrgent.class);
                i.putExtra("symp10",".Excessive Flushing");
                i.putExtra("sol10","For best results, apply a pea-sized amount to 5 main areas of the face – each cheek, the nose, chin and forehead. Spread evenly. Apply in the morning only.\n" +
                        "\n" +
                        "Never undergo treatment when you have tanned skin as you risk getting colour change to the skin, burns and scarring. Do consider having your treatments performed at a medical clinic supervised by a physician. Avoid Triggers and maintain good skincare.\n.");
                startActivity(i);
            }
        });
        tvSymp11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),RemediesNotUrgent.class);
                i.putExtra("symp11","Q.What is IndiaNeoDesign?");
                i.putExtra("sol11","IndiaNeoDessign offers a professional input about your skin condition based on your uploaded images and text from a dermatologist.\n\n"+"Our service bridges the gap between an internet search and in-person dermatologist consulation.\n\n"+"Our team of dermatalogist is here around the clock to provide you an expert input on your skin concerns.");
                startActivity(i);
            }
        });
        tvSymp12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),RemediesNotUrgent.class);
                i.putExtra("symp12","Q.What is IndiaNeoDesign?");
                i.putExtra("sol12","IndiaNeoDessign offers a professional input about your skin condition based on your uploaded images and text from a dermatologist.\n\n"+"Our service bridges the gap between an internet search and in-person dermatologist consulation.\n\n"+"Our team of dermatalogist is here around the clock to provide you an expert input on your skin concerns.");
                startActivity(i);

            }

        });













    }
}
