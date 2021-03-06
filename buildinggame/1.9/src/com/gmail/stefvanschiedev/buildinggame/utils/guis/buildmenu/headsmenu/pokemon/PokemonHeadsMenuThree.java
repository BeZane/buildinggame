package com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu.headsmenu.pokemon;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.utils.nbt.item.NBTItem;
import com.gmail.stefvanschiedev.buildinggame.utils.nbt.item.skull.SkullItem;

public class PokemonHeadsMenuThree {
	
	public void show(Player player) {
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		Inventory inventory = Bukkit.createInventory(null, 54, MessageManager.translate(messages.getString("gui.heads.pokemon.page-3.title")));
		
		ItemStack noivern = SkullItem.getSkull("http://textures.minecraft.net/texture/f3e87cbba27059f5e8c34f599c25aab9422063eaba802c32776b3d80aad74f69");
		ItemMeta noivernMeta = noivern.getItemMeta();
		noivernMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.pokemon.page-3.noivern.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.pokemon.page-3.noivern.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			noivernMeta.setLore(lores);
		}
		noivern.setItemMeta(noivernMeta);
		
		ItemStack jigglypuff = SkullItem.getSkull("http://textures.minecraft.net/texture/ba6f12621e5363595bc6d68fa185cedfceaada3d82b60c13fdc4a03269");
		ItemMeta jigglypuffMeta = jigglypuff.getItemMeta();
		jigglypuffMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.pokemon.page-3.jigglypuff.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.pokemon.page-3.jigglypuff.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			jigglypuffMeta.setLore(lores);
		}
		jigglypuff.setItemMeta(jigglypuffMeta);
		
		ItemStack grovyle = SkullItem.getSkull("http://textures.minecraft.net/texture/755cae4913e97f49838d4a8ddf711f9598d562bcb58e39f3d41c60d3be721");
		ItemMeta grovyleMeta = grovyle.getItemMeta();
		grovyleMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.pokemon.page-3.grovyle.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.pokemon.page-3.grovyle.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			grovyleMeta.setLore(lores);
		}
		grovyle.setItemMeta(grovyleMeta);
		
		ItemStack gabite = SkullItem.getSkull("http://textures.minecraft.net/texture/14832ce2e65ac196482afe46dffcfd8529bc4779ccb7e9a52dfa5cbda144d5c");
		ItemMeta gabiteMeta = gabite.getItemMeta();
		gabiteMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.pokemon.page-3.gabite.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.pokemon.page-3.gabite.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			gabiteMeta.setLore(lores);
		}
		gabite.setItemMeta(gabiteMeta);
		
		ItemStack pokemonEgg = SkullItem.getSkull("http://textures.minecraft.net/texture/e2a850feabb07349cfe245b26a264ea36df73338f84cd2ee3833b185e1e2e2d8");
		ItemMeta pokemonEggMeta = pokemonEgg.getItemMeta();
		pokemonEggMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.pokemon.page-3.pokemon-egg.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.pokemon.page-3.pokemon-egg.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			pokemonEggMeta.setLore(lores);
		}
		pokemonEgg.setItemMeta(pokemonEggMeta);
		
		ItemStack articuno = SkullItem.getSkull("http://textures.minecraft.net/texture/fd4b9867dede93e8f226ff91b77d7a3ccaf3f6b1ef5f486ce62d11e943");
		ItemMeta articunoMeta = articuno.getItemMeta();
		articunoMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.pokemon.page-3.articuno.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.pokemon.page-3.articuno.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			articunoMeta.setLore(lores);
		}
		articuno.setItemMeta(articunoMeta);
		
		ItemStack luxray = SkullItem.getSkull("http://textures.minecraft.net/texture/406051fc28fcfdbefb543ad78a2b254b254dd6f171c7346b46a46dd3923f");
		ItemMeta luxrayMeta = luxray.getItemMeta();
		luxrayMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.pokemon.page-3.luxray.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.pokemon.page-3.luxray.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			luxrayMeta.setLore(lores);
		}
		luxray.setItemMeta(luxrayMeta);
		
		ItemStack arcanine = SkullItem.getSkull("http://textures.minecraft.net/texture/c430bda19c47bc791be11f5c74bcbd83effc606d291bb4d36988b766f6c6");
		ItemMeta arcanineMeta = arcanine.getItemMeta();
		arcanineMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.pokemon.page-3.arcanine.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.pokemon.page-3.arcanine.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			arcanineMeta.setLore(lores);
		}
		arcanine.setItemMeta(arcanineMeta);
		
		ItemStack mightyena = SkullItem.getSkull("http://textures.minecraft.net/texture/d755de85c6b376206f8011f9cdf59414ade201fe4349be0ea15a7897e7014fa");
		ItemMeta mightyenaMeta = mightyena.getItemMeta();
		mightyenaMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.pokemon.page-3.mightyena.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.pokemon.page-3.mightyena.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			mightyenaMeta.setLore(lores);
		}
		mightyena.setItemMeta(mightyenaMeta);
		
		ItemStack eevee = SkullItem.getSkull("http://textures.minecraft.net/texture/a044e9d19bef47933aff42bce4b458f431315090d613f54b6e795da59db9d0de");
		ItemMeta eeveeMeta = eevee.getItemMeta();
		eeveeMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.pokemon.page-3.eevee.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.pokemon.page-3.eevee.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			eeveeMeta.setLore(lores);
		}
		eevee.setItemMeta(eeveeMeta);
		
		ItemStack vulpix = SkullItem.getSkull("http://textures.minecraft.net/texture/92b764a7317e901c7bd8c248cd1387e6af6bc8335b89d923f618f8febbfb95");
		ItemMeta vulpixMeta = vulpix.getItemMeta();
		vulpixMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.pokemon.page-3.vulpix.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.pokemon.page-3.vulpix.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			vulpixMeta.setLore(lores);
		}
		vulpix.setItemMeta(vulpixMeta);
		
		ItemStack gengar = SkullItem.getSkull("http://textures.minecraft.net/texture/1428bcb2ad62567e1bd0d4dac6f473fe9de175db117422144c46575ff5e1");
		ItemMeta gengarMeta = gengar.getItemMeta();
		gengarMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.pokemon.page-3.gengar.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.pokemon.page-3.gengar.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			gengarMeta.setLore(lores);
		}
		gengar.setItemMeta(gengarMeta);
		
		ItemStack raichu = SkullItem.getSkull("http://textures.minecraft.net/texture/abf523f2bd90b3ff1944515b6a324338aad47ea1f2ce93f82d5564c4c9ade71");
		ItemMeta raichuMeta = raichu.getItemMeta();
		raichuMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.pokemon.page-3.raichu.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.pokemon.page-3.raichu.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			raichuMeta.setLore(lores);
		}
		raichu.setItemMeta(raichuMeta);
		
		ItemStack beedrill = SkullItem.getSkull("http://textures.minecraft.net/texture/ac48ca1ce447c1daa399b4de63bb190667f887caf6e3e8ed537f090a5fb64b8");
		ItemMeta beedrillMeta = beedrill.getItemMeta();
		beedrillMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.pokemon.page-3.beedrill.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.pokemon.page-3.beedrill.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			beedrillMeta.setLore(lores);
		}
		beedrill.setItemMeta(beedrillMeta);
		
		ItemStack cubchoo = SkullItem.getSkull("http://textures.minecraft.net/texture/a4f451523dd66c4e892ae59aa79e9ddcc52904547f5df5f683108ddd422fec");
		ItemMeta cubchooMeta = cubchoo.getItemMeta();
		cubchooMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.pokemon.page-3.cubchoo.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.pokemon.page-3.cubchoo.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			cubchooMeta.setLore(lores);
		}
		cubchoo.setItemMeta(cubchooMeta);
		
		ItemStack bidoof = SkullItem.getSkull("http://textures.minecraft.net/texture/e7a5e52183e41b28de41d9038883d399dc587d4eb230e696d8f6be6d3e57cf");
		ItemMeta bidoofMeta = bidoof.getItemMeta();
		bidoofMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.pokemon.page-3.bidoof.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.pokemon.page-3.bidoof.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			bidoofMeta.setLore(lores);
		}
		bidoof.setItemMeta(bidoofMeta);
		
		ItemStack buizel = SkullItem.getSkull("http://textures.minecraft.net/texture/2440972f1dcb244872d2f1026daceb94dadb9851ca5932e15154ffe7e3be8");
		ItemMeta buizelMeta = buizel.getItemMeta();
		buizelMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.pokemon.page-3.buizel.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.pokemon.page-3.buizel.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			buizelMeta.setLore(lores);
		}
		buizel.setItemMeta(buizelMeta);
		
		ItemStack arceus = SkullItem.getSkull("http://textures.minecraft.net/texture/3c7eade726b391f7f3ab5d8b5cfc7376558baa885de229d6dcbd6b64ec89aa70");
		ItemMeta arceusMeta = arceus.getItemMeta();
		arceusMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.pokemon.page-3.arceus.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.pokemon.page-3.arceus.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			arceusMeta.setLore(lores);
		}
		arceus.setItemMeta(arceusMeta);
		
		ItemStack flaaffy = SkullItem.getSkull("http://textures.minecraft.net/texture/fa2137f3844b031432e3236317d5553fb247efe72ee686b859cdcc4f19e2c3");
		ItemMeta flaaffyMeta = flaaffy.getItemMeta();
		flaaffyMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.pokemon.page-3.flaaffy.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.pokemon.page-3.flaaffy.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			flaaffyMeta.setLore(lores);
		}
		flaaffy.setItemMeta(flaaffyMeta);
		
		ItemStack deino = SkullItem.getSkull("http://textures.minecraft.net/texture/fb9a67c7905d1ae7c8653f6a6e9f54919f8926d3671423a5fafae6c95b9298");
		ItemMeta deinoMeta = deino.getItemMeta();
		deinoMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.pokemon.page-3.deino.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.pokemon.page-3.deino.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			deinoMeta.setLore(lores);
		}
		deino.setItemMeta(deinoMeta);
		
		ItemStack muk = SkullItem.getSkull("http://textures.minecraft.net/texture/9ae568ee5978349adc63a5bf37f082ef5512bb264cdb7598efecd71f42d13");
		ItemMeta mukMeta = muk.getItemMeta();
		mukMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.pokemon.page-3.muk.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.pokemon.page-3.muk.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			mukMeta.setLore(lores);
		}
		muk.setItemMeta(mukMeta);
		
		ItemStack oshawott = SkullItem.getSkull("http://textures.minecraft.net/texture/62b1b36b298597cda26f72652caf84e0e7ddfab54dff6f5259371743e2585");
		ItemMeta oshawottMeta = oshawott.getItemMeta();
		oshawottMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.pokemon.page-3.oshawott.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.pokemon.page-3.oshawott.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			oshawottMeta.setLore(lores);
		}
		oshawott.setItemMeta(oshawottMeta);
		
		ItemStack cresselia = SkullItem.getSkull("http://textures.minecraft.net/texture/18c8da5a2a773ce4f5f529674c2df505e6fb8e85d71399b1f56640beb2fde7");
		ItemMeta cresseliaMeta = cresselia.getItemMeta();
		cresseliaMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.pokemon.page-3.cresselia.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.pokemon.page-3.cresselia.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			cresseliaMeta.setLore(lores);
		}
		cresselia.setItemMeta(cresseliaMeta);
		
		ItemStack yveltal = SkullItem.getSkull("http://textures.minecraft.net/texture/15ae64c87de451ff1128251493537eae3ed5362980aacd591cb5e12b5cf7a257");
		ItemMeta yveltalMeta = yveltal.getItemMeta();
		yveltalMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.pokemon.page-3.yveltal.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.pokemon.page-3.yveltal.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			yveltalMeta.setLore(lores);
		}
		yveltal.setItemMeta(yveltalMeta);
		
		ItemStack wailord = SkullItem.getSkull("http://textures.minecraft.net/texture/421142172424b210b17a9ca2f449a44495184adf83c964d385fa758a120");
		ItemMeta wailordMeta = wailord.getItemMeta();
		wailordMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.pokemon.page-3.wailord.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.pokemon.page-3.wailord.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			wailordMeta.setLore(lores);
		}
		wailord.setItemMeta(wailordMeta);
		
		ItemStack moltres = SkullItem.getSkull("http://textures.minecraft.net/texture/2cf022a89ef21fada26d9f648e15cdf43f2edb74971f4423ceb5ac4a343a5f");
		ItemMeta moltresMeta = moltres.getItemMeta();
		moltresMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.pokemon.page-3.moltres.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.pokemon.page-3.moltres.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			moltresMeta.setLore(lores);
		}
		moltres.setItemMeta(moltresMeta);
		
		ItemStack mew = SkullItem.getSkull("http://textures.minecraft.net/texture/35cd3c72dcc7eedcffcb2221b38b5b8ac4705ffdc457461a816538874b4cf");
		ItemMeta mewMeta = mew.getItemMeta();
		mewMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.pokemon.page-3.mew.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.pokemon.page-3.mew.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			mewMeta.setLore(lores);
		}
		mew.setItemMeta(mewMeta);
		
		ItemStack zygarde = SkullItem.getSkull("http://textures.minecraft.net/texture/5054a019f45d7aa619dd5be1d4e68c79c0dfacb260681439c7b413869c8dc7");
		ItemMeta zygardeMeta = zygarde.getItemMeta();
		zygardeMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.pokemon.page-3.zygarde.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.pokemon.page-3.zygarde.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			zygardeMeta.setLore(lores);
		}
		zygarde.setItemMeta(zygardeMeta);
		
		ItemStack zapdos = SkullItem.getSkull("http://textures.minecraft.net/texture/49a66f3d258d927f7e4818148bac67b23e7924a93b89f3c96b8754bfcb48f75");
		ItemMeta zapdosMeta = zapdos.getItemMeta();
		zapdosMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.pokemon.page-3.zapdos.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.pokemon.page-3.zapdos.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			zapdosMeta.setLore(lores);
		}
		zapdos.setItemMeta(zapdosMeta);
		
		ItemStack manaphy = SkullItem.getSkull("http://textures.minecraft.net/texture/c71f2f1d5e4feae6f893816a8cc789155366747264f9a36efc713bb8f9c3d6");
		ItemMeta manaphyMeta = manaphy.getItemMeta();
		manaphyMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.pokemon.page-3.manaphy.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.pokemon.page-3.manaphy.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			manaphyMeta.setLore(lores);
		}
		manaphy.setItemMeta(manaphyMeta);
		
		ItemStack koffing = SkullItem.getSkull("http://textures.minecraft.net/texture/f176dec49a931096a09b22add0402ab2c7f48987711091d018e02b4bb1e57");
		ItemMeta koffingMeta = koffing.getItemMeta();
		koffingMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.pokemon.page-3.koffing.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.pokemon.page-3.koffing.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			koffingMeta.setLore(lores);
		}
		koffing.setItemMeta(koffingMeta);
		
		ItemStack omanyte = SkullItem.getSkull("http://textures.minecraft.net/texture/ac738fcb69c48ef60d654da4c2c493c75b7c29fbf8d836bdf5f98bcab8ba");
		ItemMeta omanyteMeta = omanyte.getItemMeta();
		omanyteMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.pokemon.page-3.omanyte.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.pokemon.page-3.omanyte.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			omanyteMeta.setLore(lores);
		}
		omanyte.setItemMeta(omanyteMeta);
		
		ItemStack cubone = SkullItem.getSkull("http://textures.minecraft.net/texture/7a4fa71ad28cd1e1b7ea93581730825cba96cac3cd3b1bc72a97ea54de534");
		ItemMeta cuboneMeta = cubone.getItemMeta();
		cuboneMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.pokemon.page-3.cubone.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.pokemon.page-3.cubone.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			cuboneMeta.setLore(lores);
		}
		cubone.setItemMeta(cuboneMeta);
		
		ItemStack voltorb = SkullItem.getSkull("http://textures.minecraft.net/texture/e2f3f9cca77c725217e45ad4eeeeffa0565f82b866ac67999b43c3a97311628c");
		ItemMeta voltorbMeta = voltorb.getItemMeta();
		voltorbMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.pokemon.page-3.voltorb.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.pokemon.page-3.voltorb.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			voltorbMeta.setLore(lores);
		}
		voltorb.setItemMeta(voltorbMeta);
		
		ItemStack electrode = SkullItem.getSkull("http://textures.minecraft.net/texture/5eefe1191579957c83250a8ce8fefd55f4d76c50d81094c9209895f4bd600");
		ItemMeta electrodeMeta = electrode.getItemMeta();
		electrodeMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.pokemon.page-3.electrode.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.pokemon.page-3.electrode.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			electrodeMeta.setLore(lores);
		}
		electrode.setItemMeta(electrodeMeta);
		
		ItemStack weedle = SkullItem.getSkull("http://textures.minecraft.net/texture/629659d11e2d4f30c3e5947a1fc9321a8d9c105ed72e927a50cb3e8d7291533");
		ItemMeta weedleMeta = weedle.getItemMeta();
		weedleMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.pokemon.page-3.weedle.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.pokemon.page-3.weedle.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			weedleMeta.setLore(lores);
		}
		weedle.setItemMeta(weedleMeta);
		
		ItemStack kakuna = SkullItem.getSkull("http://textures.minecraft.net/texture/9a9a801f119c631a9c9fa047a2c25bc0b6cbf908237d74cb1a41085107c597");
		ItemMeta kakunaMeta = kakuna.getItemMeta();
		kakunaMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.pokemon.page-3.kakuna.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.pokemon.page-3.kakuna.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			kakunaMeta.setLore(lores);
		}
		kakuna.setItemMeta(kakunaMeta);
		
		//previous page
		ItemStack previous = new ItemStack (Material.SUGAR_CANE);
		ItemMeta previousMeta = previous.getItemMeta();
		previousMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.pokemon.page-3.previous-page.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.pokemon.page-3.previous-page.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			previousMeta.setLore(lores);
		}
		previous.setItemMeta(previousMeta);
		NBTItem previousNbt = new NBTItem(previous);
		previousNbt.setInteger("page", 2);
		previous = previousNbt.getItem();
		
		//close
		ItemStack close = new ItemStack(Material.BOOK);
		ItemMeta closeMeta = close.getItemMeta();
		closeMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.pokemon.page-3.close.name")));
		{
			List<String> lores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.pokemon.page-3.close.lores")) {
				lores.add(MessageManager.translate(lore));
			}
			closeMeta.setLore(lores);
		}
		close.setItemMeta(closeMeta);
		
		inventory.setItem(0, noivern);
		inventory.setItem(1, jigglypuff);
		inventory.setItem(2, grovyle);
		inventory.setItem(3, gabite);
		inventory.setItem(4, pokemonEgg);
		inventory.setItem(5, articuno);
		inventory.setItem(6, luxray);
		inventory.setItem(7, arcanine);
		inventory.setItem(8, mightyena);
		inventory.setItem(9, eevee);
		inventory.setItem(10, vulpix);
		inventory.setItem(11, gengar);
		inventory.setItem(12, raichu);
		inventory.setItem(13, beedrill);
		inventory.setItem(14, cubchoo);
		inventory.setItem(15, bidoof);
		inventory.setItem(16, buizel);
		inventory.setItem(17, arceus);
		inventory.setItem(18, flaaffy);
		inventory.setItem(19, deino);
		inventory.setItem(20, muk);
		inventory.setItem(21, oshawott);
		inventory.setItem(22, cresselia);
		inventory.setItem(23, yveltal);
		inventory.setItem(24, wailord);
		inventory.setItem(25, moltres);
		inventory.setItem(26, mew);
		inventory.setItem(27, zygarde);
		inventory.setItem(28, zapdos);
		inventory.setItem(29, manaphy);
		inventory.setItem(30, koffing);
		inventory.setItem(31, omanyte);
		inventory.setItem(32, cubone);
		inventory.setItem(33, voltorb);
		inventory.setItem(34, electrode);
		inventory.setItem(35, weedle);
		inventory.setItem(36, kakuna);
		
		inventory.setItem(47, previous);
		inventory.setItem(49, close);
		
		player.openInventory(inventory);
	}
}